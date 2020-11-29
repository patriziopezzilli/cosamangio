package com.cosamangio.service;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploaderFTPService {

    public void upload(MultipartFile file, String merchantCode, String prefix) {
        String FTP_ADDRESS = "ftp.ristorantemonopoli.com";
        String LOGIN = "10733989@aruba.it";
        String PSW = "Lautaro10";

        FTPClient con = null;

        try {
            con = new FTPClient();
            con.connect(FTP_ADDRESS);

            if (con.login(LOGIN, PSW)) {
                con.enterLocalPassiveMode();
                con.setFileType(FTP.BINARY_FILE_TYPE);

                boolean result = con.storeFile("public_html/ristoranti/" + prefix + file.getOriginalFilename(), file.getInputStream());
                con.logout();
                con.disconnect();

                System.out.println("> [SUCCESS] uploaded logo for merchant " + merchantCode);
            }
        } catch (Exception e) {
            System.out.println("> [ERROR] failed to upload logo for merchant " + merchantCode);
        }
    }
}
