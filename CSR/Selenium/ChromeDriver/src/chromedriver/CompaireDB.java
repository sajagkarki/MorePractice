package chromedriver;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.tdw.csr.dao.AppurtenancesAndAttachmentsDAO;
import com.tdw.csr.dao.BendsDAO;
import com.tdw.csr.dao.CSRFilter;
import com.tdw.csr.dao.CasingsDAO;
import com.tdw.csr.dao.DeformationsDAO;
import com.tdw.csr.dao.DentsDAO;
import com.tdw.csr.dao.EntityFilter;
import com.tdw.csr.dao.GainsDAO;
import com.tdw.csr.dao.GirthWeldAnomalyDAO;
import com.tdw.csr.dao.MarkersDAO;
import com.tdw.csr.dao.MetalLossDAO;
import com.tdw.csr.dao.MiscellaneousDAO;
import com.tdw.csr.dao.PitsDAO;
import com.tdw.csr.dao.RepairsDAO;
import com.tdw.csr.dao.ReportingDataSheetDAO;
import com.tdw.csr.dao.StandardReportManifestsDAO;
import com.tdw.csr.dao.ValvesDAO;
import com.tdw.csr.dao.WallThicknessDAO;
import com.tdw.csr.dao.WeldsDAO;
import com.tdw.csr.entity.CSRDoc;
import com.tdw.csr.entity.Entity;

import com.tdw.csr.entity.appurtenances_attachments.AppurtenancesAndAttachments;
import com.tdw.csr.entity.bends.Bends;
import com.tdw.csr.entity.casings.Casings;
import com.tdw.csr.entity.deformations.Deformations;
import com.tdw.csr.entity.deformations.dents.*;
import com.tdw.csr.entity.gains.Gains;
import com.tdw.csr.entity.markers.Markers;
import com.tdw.csr.entity.metal_loss.MetalLoss;
import com.tdw.csr.entity.metal_loss.pits.Pits;
import com.tdw.csr.entity.miscellaneous.Miscellaneous;
import com.tdw.csr.entity.repairs.Repairs;
import com.tdw.csr.entity.reporting_data_sheet.ReportingDataSheet;
import com.tdw.csr.entity.standard_report_manifests.StandardReportManifests;
import com.tdw.csr.entity.valves.Valves;
import com.tdw.csr.entity.wall_thickness.WallThickness;
import com.tdw.csr.entity.welds.Welds;
import com.tdw.csr.entity.girth_weld_anomaly.*;

import chromedriver.ElementValidationInterface;
import chromedriver.UIElements.ConfigurationErrorElement;

public class CompaireDB extends BaseCDTest{
	
	private AppurtenancesAndAttachmentsDAO createAADAO() {
		try {
			AppurtenancesAndAttachmentsDAO dao = new AppurtenancesAndAttachmentsDAO(mc);
			return dao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create AppurtenancesAndAttachmentsDAO");
		}
	}
	
	private BendsDAO createBDAO() {
		try {
			BendsDAO bdao = new BendsDAO(mc);
			return bdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create BendsDAO");
		}
	}
	
	private CasingsDAO createCDAO() {
		try {
			CasingsDAO cdao = new CasingsDAO(mc);
			return cdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create CasingsDAO");
		}
	}
	
	private DeformationsDAO createDDAO() {
		try {
			DeformationsDAO ddao = new DeformationsDAO(mc);
			return ddao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create DeformationsDAO");
		}
	}
	
	private DentsDAO createDentDAO() {
		try {
			DentsDAO dentdao = new DentsDAO(mc);
			return dentdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create DentsDAO");
		}
	}
	
	private GainsDAO createGDAO() {
		try {
			GainsDAO gaindao = new GainsDAO(mc);
			return gaindao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create GainsDAO");
		}
	}
	
	private MarkersDAO createMDAO() {
		try {
			MarkersDAO markersdao = new MarkersDAO(mc);
			return markersdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create MarkersDAO");
		}
	}
	
	private MetalLossDAO createMLDAO() {
		try {
			MetalLossDAO mldao = new MetalLossDAO(mc);
			return mldao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create MetalLossDAO");
		}
	}
	
	private PitsDAO createPitsDAO() {
		try {
			PitsDAO pdao = new PitsDAO(mc);
			return pdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create PitsDAO");
		}
	}
	
	private GirthWeldAnomalyDAO createGWADAO() {
		try {
			GirthWeldAnomalyDAO gwadao = new GirthWeldAnomalyDAO(mc);
			return gwadao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create GWADAO");
		}
	}
	
	private MiscellaneousDAO createMiscDAO() {
		try {
			MiscellaneousDAO mdao = new MiscellaneousDAO(mc);
			return mdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create MiscDAO");
		}
	}
	
	private RepairsDAO createRepairsDAO() {
		try {
			RepairsDAO rdao = new RepairsDAO(mc);
			return rdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create RepairsDAO");
		}
	}
	
	private ReportingDataSheetDAO createRDSDAO() {
		try {
			ReportingDataSheetDAO rdsdao = new ReportingDataSheetDAO(mc);
			return rdsdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create RDSDAO");
		}
	}
	
	private StandardReportManifestsDAO createSRMDAO() {
		try {
			StandardReportManifestsDAO srmdao = new StandardReportManifestsDAO(mc);
			return srmdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create SRMDAO");
		}
	}
	
	private ValvesDAO createValvesDAO() {
		try {
			ValvesDAO vdao = new ValvesDAO(mc);
			return vdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create VDAO");
		}
	}
	
	private WeldsDAO createWeldsDAO() {
		try {
			WeldsDAO wdao = new WeldsDAO(mc);
			return wdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create WeldsDAO");
		}
	}
	
	private WallThicknessDAO CreateWTDAO() {
		try {
			WallThicknessDAO wtdao = new WallThicknessDAO(mc);
			return wtdao;
		} catch (IOException e) {
			throw new RuntimeException("Couldn't create WTDAO");
		}
	}
	
	//This class is meant to be converted into JSON by GSON to the appropriate debug text.
	//Each debugJsonHolder object represents the debug info of One UIElement.
	private class debugJsonHolder {
		String Name = "Not Input";
		String Test_Value = "Not Input";
		String DB_Value = "Not Input";
		String Result = "Not Input";
	}
	
	enum tables{
		APPURTENANCES_AND_ATTACHMENTS,
		BENDS,
		CASINGS,
		DEFORMATIONS,
		DENTS,
		GAINS,
		MARKERS,
		METAL_LOSS,
		GIRTH_WELD_ANOMALY,
		PITS,
		MISCELLANEOUS,
		REPAIRS,
		REPORTING_DATA_SHEET,
		STANDARD_REPORT_MANIFESTS,
		VALVES,
		WELDS, WALL_THICKNESS
	}
	
	/**
	 * Validates the inputs with the database result.
	 * This will print out a JSON file, showing all the test results in detail.
	 * 
	 * @param elements A List of the element which are being validated
	 * @param page The name of the CSR page being tested
	 * @param fileCounter The test configuration count, to prevent saving over the same test.
	 * @throws IOException 
	 */
	public void compaireDB(List<UIElements> elements, String page, tables type, String fileName, int fileCounter) throws IOException {
		
		Gson gson = new Gson();
		String json = "{\"" + page + " Page - Test " + fileCounter + "\": {"; //Begin tag-line
		
		AppurtenancesAndAttachmentsDAO dao = createAADAO();
		BendsDAO bdao = createBDAO();
		CasingsDAO cdao = createCDAO();
		DeformationsDAO ddao = createDDAO();
		DentsDAO dentdao = createDentDAO();
		GainsDAO gaindao = createGDAO();
		MarkersDAO markersdao = createMDAO();
		MetalLossDAO mldao = createMLDAO();
		PitsDAO pdao = createPitsDAO();
		GirthWeldAnomalyDAO gwadao = createGWADAO();
		MiscellaneousDAO mdao = createMiscDAO();
		RepairsDAO rdao = createRepairsDAO();
		ReportingDataSheetDAO rdsdao = createRDSDAO();
		StandardReportManifestsDAO srmdao = createSRMDAO();
		ValvesDAO vdao = createValvesDAO();
		WeldsDAO wdao = createWeldsDAO();
		WallThicknessDAO wtdao = CreateWTDAO();

		//sets up the database connection and variables.
		// EntityFilter eF = new EntityFilter();
		CSRFilter cF = new CSRFilter();
		cF.companyCode = "CSR-DB-TEST";
		List<CSRDoc> cdl = dao.getCSRByFilter(cF);
		String id = "";
		List<? extends Entity> list = null;
		EntityFilter eF = null;
		
		// Get the database information as needed.
		switch(type) {
			case APPURTENANCES_AND_ATTACHMENTS:
				id = cdl.get(0).appurtenancesAndAttachmentsID;
				list = new ArrayList<AppurtenancesAndAttachments>();
				eF = new EntityFilter(id);
				list = dao.getAppurtenancesAndAttachmentsByFilter(eF);
				break;
			case BENDS: 
				id = cdl.get(0).bendsID;
				list = new ArrayList<Bends>();
				eF = new EntityFilter(id);
				list = bdao.getBendsByFilter(eF);
				break;
			case CASINGS:
				id = cdl.get(0).casingsID;
				list = new ArrayList<Casings>();
				eF = new EntityFilter(id);
				list = cdao.getCasingsByFilter(eF);
				break;
			case DEFORMATIONS:
				id = cdl.get(0).defID;
				list = new ArrayList<Deformations>();
				eF = new EntityFilter(id);
				list = ddao.getDeformationsByFilter(eF);
				break;
			case DENTS:
				id = cdl.get(0).dentsID;
				list = new ArrayList<Dents>();
				eF = new EntityFilter(id);
				list = dentdao.getDentsByFilter(eF);
				break;
			case GAINS: 
				id = cdl.get(0).gainsID;
				list = new ArrayList<Gains>();
				eF = new EntityFilter(id);
				list = gaindao.getGainsByFilter(eF);
				break;
			case MARKERS:
				id = cdl.get(0).markersID;
				list = new ArrayList<Markers>();
				eF = new EntityFilter(id);
				list = markersdao.getMarkersByFilter(eF);
				break;
			case PITS:
				id = cdl.get(0).pitsID;
				list = new ArrayList<Pits>();
				eF = new EntityFilter(id);
				list = pdao.getPitsByFilter(eF);
				break;
			case METAL_LOSS:
				id = cdl.get(0).metalID;
				list = new ArrayList<MetalLoss>();
				eF = new EntityFilter(id);
				list = mldao.getMetalLossByFilter(eF);
				break;
			case GIRTH_WELD_ANOMALY:
				id = cdl.get(0).gwaID;
				list = new ArrayList<GirthWeldAnomaly>();
				eF = new EntityFilter(id);
				list = gwadao.getGirthWeldAnomalyByFilter(eF);
				break;
			case MISCELLANEOUS: 
				id = cdl.get(0).miscID;
				list = new ArrayList<Miscellaneous>();
				eF = new EntityFilter(id);
				list = mdao.getMiscellaneousByFilter(eF);
				break;
			case REPAIRS:
				id = cdl.get(0).repairsID;
				list = new ArrayList<Repairs>();
				eF = new EntityFilter(id);
				list = rdao.getRepairsByFilter(eF);
				break;
			case REPORTING_DATA_SHEET:
				id = cdl.get(0).rdsID;
				list = new ArrayList<ReportingDataSheet>();
				eF = new EntityFilter(id);
				list = rdsdao.getReportingDataSheetByFilter(eF);
				break;
			case STANDARD_REPORT_MANIFESTS:
				id = cdl.get(0).srmID;
				list = new ArrayList<StandardReportManifests>();
				eF = new EntityFilter(id);
				list = srmdao.getStandardReportManifestsByFilter(eF);
				break;
			case VALVES:
				id = cdl.get(0).valvesID;
				list = new ArrayList<Valves>();
				eF = new EntityFilter(id);
				list = vdao.getValvesByFilter(eF);
				break;
			case WELDS:
				id = cdl.get(0).weldsID;
				list = new ArrayList<Welds>();
				eF = new EntityFilter(id);
				list = wdao.getWeldsByFilter(eF);
				break;
			case WALL_THICKNESS:
				id = cdl.get(0).wtID;
				list = new ArrayList<WallThickness>();
				eF = new EntityFilter(id);
				list = wtdao.getWallThicknessByFilter(eF);
				break;
		}
		
		int i = 0;
		for (UIElements e : elements) {
			if(e.getClass().equals(ConfigurationErrorElement.class)) //Handle configuration errors (user errors)
			{
				json += "\"TestCase_" + i + "\": ";
				
				debugJsonHolder log = new debugJsonHolder();
				
				log.Result = "Fail"; //This Line MUST be run before recording e.returnedValues. Otherwise e.returnedValues will be null.	
				log.Name = "A Configuration error has occurred. Check that you are feeding the correct data types to the correct elements.";
				log.Test_Value = "ERROR: " + e.exceptionMessage;
				log.DB_Value = "Configuration Error, No Test Run";
				
				json += gson.toJson(log);
				
				json += ",";
				
				break;
			}
			
			if(e.validator != null)
			{
				//Constructs the JSon String and validates the tests.
				json += "\"TestCase_" + i + "\": ";
				i++;
				
				debugJsonHolder log = new debugJsonHolder();
				
				System.out.println("Printing JSON Log: " + e.elm);
				//Generate a log, while ensuring that errors are handled apropriately.
				if(e.failedExecution) //Handle a failed interaction
				{
					log.Result = "Fail"; //This Line MUST be run before recording e.returnedValues. Otherwise e.returnedValues will be null.	
					log.Name = e.elm + (e.useNameInstance != 0 ? " - " + e.useNameInstance : "");
					log.Test_Value = "ERROR: " + e.exceptionMessage;
					log.DB_Value = "Execution Error, No Result";

				}
				else //All Good?
				{
					//Run Validation
					try {
						log.Result = e.validator.validationTest(e, list) ? "Pass" : "Fail"; //This Line MUST be run before recording e.returnedValues. Otherwise e.returnedValues will be null.					
					}
					catch(Exception ex)
					{
						e.failedValidation = true;
						log.Result = "Fail"; //This Line MUST be run before recording e.returnedValues. Otherwise e.returnedValues will be null.	
						log.Test_Value = "ERROR: " + e.exceptionMessage;
						log.DB_Value = "VALIDATION ERROR";	
					}
					
					if(!e.failedValidation)
					{
						//Fill Out Log
						try {
							log.Name = e.elm + (e.useNameInstance != 0 ? " - " + e.useNameInstance : "");
							log.Test_Value = e.expectedValue;
							log.DB_Value = e.returnedValues;	
						}
						catch(Exception ex)
						{
							log.Result = "Fail"; //This Line MUST be run before recording e.returnedValues. Otherwise e.returnedValues will be null.		
							log.Name = e.elm + (e.useNameInstance != 0 ? " - " + e.useNameInstance : "");
							log.Test_Value = "LOGGING ERROR - Check that both results are not null";
							log.DB_Value = "LOGGING ERROR";					
						}
					}
					
				}
				
				json += gson.toJson(log);
				
				json += ",";
			}
			else {
				System.out.println("No Test Available: Element Skipped");
			}
		}
		
		json = json.substring(0, json.length() - 1); //Cutoff the leftover comma
		json += "}}";
		
		System.out.println(json);
		
		//Write to File
		Files.write(Paths.get("./JSONResults/" + fileName + "_" + fileCounter + ".json"), json.getBytes());                              
		
		
		
		/*
		if(e.validator != null)
		{
			if(e.validator.validationTest())
			{
				System.out.println("Test Passed: Data Valid");
			}
			else
			{
				System.out.println("Test Failed: Data Valid");
			}
		}
		
		for (UIElements e : elements) {
			switch (e.elm) {
			case "roundOrientation_cb": // Round Location Orientation Checkbox
				// code block
				if (e.bool == list.get(0).fittings.roundOrientation) {
					// write to log file test passes
					System.out.println("Round Orientatoin test passes");
				} else {
					System.out.println("Round Orientatoin test Fails");
				}
				break;
			case "prependLabel_iwv": // Add Label to begining of Description
				if (e.txtValue.equals(list.get(0).fittings.defaultDescription.value)) {
					System.out.println("Default Description test passes");
				} else {
					System.out.println("Default Description test Fails");
				}
				break;
			case "includeOrientation_cb": // Include Orientation position
				// do something here
				break;
			case "additionalNotes_ta": // Include Orientation position
				if (list.get(0).attachments.ai.additionalNotes.contentEquals(e.txtValue)) {
					System.out.println("Additional Notes test passes");
				} else {
					System.out.println("Additional test Fails");
				}
				break;
			case "stationingPrefix_iwv":

				if (e.txtValue.equals(list.get(0).fittings.stationingPrefix.value)) {
					System.out.println("Stationing Prefix test passes");

				} else if (e.bool == list.get(0).fittings.encloseStationingInBraces) {
					System.out.println("Enclose Stationing in Braces test passes");
				} else {
					System.out.println("Stationing Prefix test Fails");
				}
				// code block
				break;
			case "encloseStationing_cb":
				// code block
				break;
			default:
				// code block
			}
		}
		*/

		// componentsOrder
		// HashTable
		// defaultDescription
		// include
		// value
		// encloseStationingInBraces
		// true or false
		// includeOpeningDimensions
		// true or false
		// includeTeeClassification
		// true or false
		// orientationDescription
		// bottomOFPipe
		// description
		// prefix
		// include
		// ninetyDegreesOfPipe
		// description
		// prefix
		// topOfPipe
		// description
		// prefix
		// twoSeventyDegreesOfPipe
		// description
		// prefix
		// roundLocationOrientations
		// true or false
		// roundOpeningDimensions
		// Include
		// units
		// value
		// stationingPrefix
		// Include
		// value
		 
	}

}
