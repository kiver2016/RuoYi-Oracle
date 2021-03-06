package com.zhzx.web.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhzx.common.config.Global;
import com.zhzx.common.config.ServerConfig;
import com.zhzx.common.constant.Constants;
import com.zhzx.common.core.domain.AjaxResult;
import com.zhzx.common.utils.StringUtils;
import com.zhzx.common.utils.file.FileUploadUtils;
import com.zhzx.common.utils.file.FileUtils;
import com.zhzx.ims.domain.CustomerInfo;
import com.zhzx.ims.domain.MaterialInfo;
import com.zhzx.ims.service.ICustomerInfoService;
import com.zhzx.ims.service.IMaterialInfoService;

/**
 * 通用请求处理
 * 
 * @author ruoyi
 */
@Controller
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private IMaterialInfoService materialInfoService;
    @Autowired
    private ICustomerInfoService customerInfoService;

    /**
     * 通用下载请求
     * 
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            if (!FileUtils.isValidFilename(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = Global.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = Global.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // 本地资源路径
        String localPath = Global.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }
    /**
     * 获取产品基础数据
     */
    @GetMapping("/selectMaterialInfoList")
    @ResponseBody
    public AjaxResult selectMaterialInfoList()
    {
        AjaxResult ajax = new AjaxResult();
        MaterialInfo materialInfo = new MaterialInfo();
        List<MaterialInfo> materialInfoList = materialInfoService.selectMaterialInfoList(materialInfo);
        ajax.put("code", 200);
        ajax.put("value", materialInfoList);
        return ajax;
    }
    /**
     * 顾客基本信息
     */
    @GetMapping("/selectCustomerInfoList")
    @ResponseBody
    public AjaxResult selectCustomerInfoList()
    {
        AjaxResult ajax = new AjaxResult();
        CustomerInfo customerInfo = new CustomerInfo();
        List<CustomerInfo> customerInfoList = customerInfoService.selectCustomerInfoList(customerInfo);
        ajax.put("code", 200);
        ajax.put("value", customerInfoList);
        return ajax;
    }
}
