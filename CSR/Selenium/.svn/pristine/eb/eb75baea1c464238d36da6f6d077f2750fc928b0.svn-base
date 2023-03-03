package helperClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Map;

//import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Zephyr {

	private int cycleID = 0;
	private FileWriter myWriter;

	public Zephyr() {
		try {
			// this if for debug purposes.
			myWriter = new FileWriter("c:\\temp\\filename.json");
			// uncommnet the next line to create a temp file.
			// myWriter = new FileWriter(File.createTempFile("myTempFile", ".txt"));
			// myWriter.write("Files in Java might be tricky, but it is fun enough!");
			// myWriter.close();
			//System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			//System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	

	public void getProjectID() throws IOException {
		// parsing file "JSONExample.json"
		String text = request("/project?includeinactive=false");
		if (!text.equals("")) {
			JSONParser jsonParser = new JSONParser();
			Object obj = JSONValue.parse(text);
			JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				Map<String, Object> map = new Gson().fromJson(array.get(i).toString(), Map.class);
				String projectName = map.get("name").toString();
				//System.out.println(projectName);
				int projectID = 0;
				if (projectName.equals("CAR")) {
					projectID = (int) (double) map.get("id");
					GetReleases(projectID);
				}
			}
		}
	}

	private void GetReleases(int projectID) throws IOException {
		// pass projectID into this function and replace the 3
		String text = request("/release/project/" + projectID);
		if (!text.equals("")) {
			JSONParser jsonParser = new JSONParser();
			Object obj = JSONValue.parse(text);
			JSONArray array = (JSONArray) obj;
			for (int i = 0; i < array.size(); i++) {
				Map<String, Object> map = new Gson().fromJson(array.get(i).toString(), Map.class);
				String releaseVersion = map.get("name").toString();
				int releaseID = 0;
				// todo change out "Release 1.0" for command line variable
				if (releaseVersion.equals("Release 1.0")) {
					releaseID = (int) (double) map.get("id");
					GetAutomationPhase(releaseID);
				}
			}
		}
	}

	private void GetAutomationPhase(int releaseID) throws IOException {
		// pass releaseID into this function
		String text = request("/cycle/release/" + releaseID);
		text = text.substring(1, text.length() - 1);
		if (!text.equals("")) {
			Gson gson = new GsonBuilder().create();

			JsonObject job = gson.fromJson(text, JsonObject.class);
			JsonArray array = job.getAsJsonArray("cyclePhases");

			for (int i = 0; i < array.size(); i++) {
				Map<String, Object> map = new Gson().fromJson(array.get(i).toString(), Map.class);
				String cyclePhase = map.get("name").toString();
				// int releaseID = 0;
				// todo change out "Release 1.0" for command line variable
				if (cyclePhase.equals("Automation")) {
					cycleID = (int) (double) map.get("id");
					GetCycleProducts(cycleID);
				}
			}
		}
	}

	private void GetCycleProducts(int id) throws IOException {
		String text = request("/assignmenttree/" + id);
		if (!text.equals("")) {
			Gson gson = new GsonBuilder().create();
			JsonObject job = gson.fromJson(text, JsonObject.class);
			int numberOfProducts = job.getAsJsonArray("categories").size();
			myWriter.write(" { \r\n");
			for (int i = 0; i < numberOfProducts; i++) {
				String array = job.getAsJsonArray("categories").get(i).toString();
				Map<String, Object> map = new Gson().fromJson(array, Map.class);
				String name = map.get("name").toString();
				// add products to json assigned in the execution (i.e P6, Transcode)
				System.out.println(map.get("name").toString());
				myWriter.write("\"" + map.get("name").toString() + "\": {\r\n");
				int categoriesID = (int) (double) map.get("id");
				GetProductRuns(categoriesID);
				if (i < numberOfProducts - 1) {
					myWriter.write(" }, \r\n");
				} else {
					myWriter.write(" } \r\n");
				}

			}
			myWriter.write(" } \r\n");
			myWriter.close();
		}

	}

	private void GetProductRuns(int cycle) throws IOException {
		String text = request("/assignmenttree/" + cycleID);
		if (!text.equals("")) {
			Gson gson = new GsonBuilder().create();
			JsonObject job = gson.fromJson(text, JsonObject.class);
			int numberOfProducts = job.getAsJsonArray("categories").size();
			int numberOfRuns =0;		
			
			for (int i = 0; i < numberOfProducts; i++) {
				numberOfRuns = job.getAsJsonArray("categories").get(i).getAsJsonObject().get("categories").getAsJsonArray().size();
				int cycleID = Integer.parseInt(job.getAsJsonArray("categories").get(i).getAsJsonObject().get("id").toString());
				
				
				if (cycleID==cycle) {
					JsonElement c1 = job.getAsJsonArray("categories").get(i);
				
					int size = c1.getAsJsonObject().get("categories").getAsJsonArray().size();
					
					for (int k = 0; k<size; k++){
						
						
						
						String name = job.getAsJsonArray("categories").get(i).
								getAsJsonObject().getAsJsonArray("categories").get(k).
								getAsJsonObject().get("name").toString();
					
						System.out.println(name);
						myWriter.write(name+": {\r\n"); 
					
						
						int size2 = job.getAsJsonArray("categories").get(i).
						getAsJsonObject().getAsJsonArray("categories").get(k).
						getAsJsonObject().getAsJsonArray("categories").size();
						
						
						for(int j = 0; j<size2;j++){
					          //add run section name to json (i.e. New Run, Tool_Information) 
							myWriter.write("\"Folder_"+j+"\": {\r\n"); 
							JsonElement json = job.getAsJsonArray("categories").get(i).
							getAsJsonObject().getAsJsonArray("categories").get(k).
							getAsJsonObject().getAsJsonArray("categories").get(j);
							
							String releaseID = json.getAsJsonObject().get("releaseId").toString();
							String id = json.getAsJsonObject().get("id").toString();
							
							
					          GetTestCaseList(Integer.parseInt(releaseID),Integer.parseInt(id));
					          
					          
					          
					          
					         if (j<size2-1){
					        	 myWriter.write("\"FolderName\": "+json.getAsJsonObject().get("name").toString()+"\r\n");
					        	 myWriter.write(" }, \r\n");  
					          }else{
					        	  myWriter.write("\"FolderName\": "+json.getAsJsonObject().get("name").toString()+"\r\n");
					        	  myWriter.write(" }, \r\n");
					        	  myWriter.write("\"NumberOfFolders\": "+job.getAsJsonArray("categories").get(i).
											getAsJsonObject().getAsJsonArray("categories").get(k).getAsJsonObject().getAsJsonArray("categories").size()+"\r\n"); 
					          }
					        
					        }
						
						if(k<numberOfRuns-1){
							myWriter.write(" }, \r\n");
					        }else{ 
					        	myWriter.write(" }, \r\n");
					        	myWriter.write("\"NumberOfRuns\": "+numberOfRuns+"\r\n");  
					        }
						
					}	
				}
			}
		}
	}

	
	
	private void GetTestCaseList(int releaseID, int tcrCatalogTreeId) throws IOException{
		  String text = request("/execution?releaseid="+releaseID+"&parentid="+tcrCatalogTreeId+"&pagesize=100");
		  if (!text.equals("")) {
				Gson gson = new GsonBuilder().create();
				JsonObject job = gson.fromJson(text, JsonObject.class);
				JsonArray results = job.getAsJsonArray("results");
				int testCaseNum = job.getAsJsonArray("results").size();
				int testCaseCount=0;
				 for(int i =0; i<testCaseNum;i++){
					JsonArray jsonEle = job.getAsJsonArray("results").get(i).
							getAsJsonObject().get("tcrTreeTestcase").
							getAsJsonObject().get("testcase").
							getAsJsonObject().get("customFieldValues").getAsJsonArray();
							//getAsJsonObject().get("displayName");
					
					
				
					String TCAutomated ="";
					String TCName = "";
					for(int t =0; t<jsonEle.size();t++){
						String temp =jsonEle.get(t).getAsJsonObject().get("displayName").toString();
						temp = temp.substring(1, temp.length() - 1);
						
						if (temp.equals( "TC Automated")){
							String tempValue= jsonEle.get(t).getAsJsonObject().get("value").toString();
							TCAutomated = tempValue.substring(1, tempValue.length() - 1);
					      }
						
						if (temp.equals( "TC Name")){
					    	TCName = jsonEle.get(t).getAsJsonObject().get("value").toString();
					    	TCName = TCName.substring(1, TCName.length() - 1);
					      }
				
					    }
					if (TCAutomated.contentEquals("true")){
					      
						myWriter.write("\"TestCase_"+testCaseCount+"\": {\r\n");
						myWriter.write("\"ID\": \""+job.getAsJsonArray("results").get(i).
								getAsJsonObject().get("tcrTreeTestcase").
								getAsJsonObject().get("testcase").
								getAsJsonObject().get("tcrTestcaseVersionId").toString()
								+"\",\r\n");
						
						
						
						myWriter.write("\"RootID\": \""+results.get(i).getAsJsonObject().get("id")+"\",\r\n");
						myWriter.write("\"Name\": \""+TCName+"\"\r\n");
					      testCaseCount++;
					          if(i==testCaseNum-1){
					        	  myWriter.write(" }, \r\n");
					        	  myWriter.write("\"NumberOfTestCases\": "+testCaseCount+",\r\n");
					          }else{
					        	  myWriter.write(" }, \r\n");
					            }
					    }
					
					//JsonElement test = array.getAsJsonObject().get("tcrTreeTestcase");
					
					//Map<String, Object> map = new Gson().fromJson(array, Map.class);
					 
				 }
		  }
		  
		  
		  /*var testData = JSON.parse(jsontext);
		  var TestCaseCount=0  
		  var TestCaseNum = testData.results.length
		  
		  for(let i =0; i<TestCaseNum;i++){
		    TCAutomated =false
		    for(let t =0; t<testData.results[i].tcrTreeTestcase.testcase.customFieldValues.length;t++){
		      if (testData.results[i].tcrTreeTestcase.testcase.customFieldValues[t].displayName == "TC Automated"){
		        TCAutomated = testData.results[i].tcrTreeTestcase.testcase.customFieldValues[t].value
		      }
		      if (testData.results[i].tcrTreeTestcase.testcase.customFieldValues[t].displayName == "TC Name"){
		        TCName = testData.results[i].tcrTreeTestcase.testcase.customFieldValues[t].value
		      }
		    }
		    if (TCAutomated=="true")    
		      
		      oFile.Write("\"TestCase_"+TestCaseCount+"\": {\r\n");
		      oFile.Write("\"ID\": \""+testData.results[i].tcrTreeTestcase.testcase.tcrTestcaseVersionId+"\",\r\n");
		      oFile.Write("\"RootID\": \""+testData.results[i].id+"\",\r\n");
		      oFile.Write("\"Name\": \""+TCName+"\"\r\n");
		      TestCaseCount++;
		          if(i==TestCaseNum-1){
		            oFile.Write(" }, \r\n");
		            oFile.Write("\"NumberOfTestCases\": "+TestCaseCount+",\r\n");
		          }else{
		            oFile.Write(" }, \r\n");
		            //aqFile.WriteToTextFile(sTempFolder+"TestCompleteCycle.json", "\"TestCaseName\": \""+testCaseIDarr[k].name+"\"\r\n", aqFile.ctUTF8);
		          }
		    }
		  }*/  
		}
	
	
	
	
	
	
	
	
	
	
	public String request(String request) {

		// String request ="/project?includeinactive=false";

		try {
			String webPage = "http://zephyr.pie.tdwilliamson.com/flex/services/rest/v3" + request;
			String name = "test.manager";
			String password = "Test1234";

			String authString = name + ":" + password;
			//System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			//System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();

			// System.out.println("*** BEGIN ***");
			// System.out.println(result);
			// System.out.println("*** END ***");

			// result = result.substring(1, result.length() - 1);
			return result;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
