package org.restaurante.controller;
import java.io.OutputStream;


import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class reporteController {

	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ResourceLoader resourceLoader;

	@GetMapping("/reporte1")
	public void reporte1(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"Entradas.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:Entradas.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	@GetMapping("/reporte2")
	public void reporte2(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"Sopas.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:Sopas.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	@GetMapping("/reporte3")
	public void reporte3(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"Postres.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:Postres.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	@GetMapping("/reporte4")
	public void reporte4(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"Bebidas.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:Bebidas.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
