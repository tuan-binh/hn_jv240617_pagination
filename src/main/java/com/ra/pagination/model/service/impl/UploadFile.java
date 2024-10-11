package com.ra.pagination.model.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadFile
{

    public String uploadFileService(MultipartFile file)
    {
        String path = "D:\\Code\\HN_JV240617\\sources\\md3\\pagination\\src\\main\\webapp\\uploads\\";

        File dir = new File(path);
        if (!dir.exists())
        {
            dir.mkdir();
        }

        String fileName = file.getOriginalFilename();

        try
        {
            FileCopyUtils.copy(file.getBytes(), new File(path + File.separator + fileName));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return fileName;
    }

}
