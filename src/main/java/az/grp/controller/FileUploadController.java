package az.grp.controller;

import az.grp.dao.BaseDAO;
import az.grp.model.dao.*;
import org.jboss.logging.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


/**
 * Created by Hp on 2016-07-23.
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    BaseDAO baseDAO;


    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadSummary", method = RequestMethod.POST)
    @ResponseBody
    public String uploadSummary(@Param Summary sm, @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                //Save file Path

                SummaryStatus summaryStatus = new SummaryStatus();
                summaryStatus.setId((long) 2);
                Summary summary = baseDAO.findWithParams(Summary.class, "id", sm.getId());
                summary.setDocPath(" C:\\apache-tomcat-7.0.63\\tmpFiles\\ " + file.getOriginalFilename());
                summary.setSummaryStatus(summaryStatus);
                baseDAO.update(summary);


                logger.info("Server File Location=" + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + file.getOriginalFilename();
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getOriginalFilename()
                    + " because the file was empty.";
        }
    }


    @RequestMapping(value = "/uploadLaboratory", method = RequestMethod.POST)
    @ResponseBody
    public String uploadLaboratory(@Param Laboratory lb, @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "labFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                //Save lab file Path

                SummaryStatus labStatus = new SummaryStatus();
                labStatus.setId((long) 2);
                Laboratory lab = baseDAO.findWithParams(Laboratory.class, "id", lb.getId());
                lab.setDocPath(" C:\\apache-tomcat-7.0.63\\labFiles\\ " + file.getOriginalFilename());
                lab.setLaboratoryStatus(labStatus);
                baseDAO.update(lab);


                logger.info("Server File Location=" + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + file.getOriginalFilename();
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getOriginalFilename()
                    + " because the file was empty.";
        }
    }



}


