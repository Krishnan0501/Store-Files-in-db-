package com.krishna;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.krishna.dao.FilePost;

public class FilestoDB extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> files=sf.parseRequest(req);
			for(FileItem file:files) {
				if (!file.isFormField()) {

					InputStream fileContent = file.getInputStream();
					String fileName = file.getName();
					FilePost fp=new FilePost();
					fp.postFiles(fileName, fileContent);
				}
			}

			res.getWriter().println("File(s) uploaded and stored in the database successfully!");
		} catch (Exception e) {
			try {
				res.getWriter().println("File upload failed: " + e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}



