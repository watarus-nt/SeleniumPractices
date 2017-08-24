package utils.Listeners;

import org.testng.*;
import org.testng.xml.XmlSuite;
import utils.Constants;
import utils.Logs.Log;
import utils.Utility;

public class TestNGCustom extends TestListenerAdapter implements ISuiteListener {


    @Override
    public void onFinish(ISuite suite) {

        System.out.println("*******Ending the suite:" + suite.getName() + ".");
        // Create the excel report and send email
        try {

            Log log = new Log();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("*******Starting the suite:" + suite.getName());


    }

    // Dat eneded


    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
    }


    // Take screen shot only for failed method <test case>
    @Override
    public void onTestFailure(ITestResult tr) {
        String logPath = Constants.TCIDPath;
        String picPath = getTestClass(tr.getMethod().toString()) + "_Failed";


//		//Clean up all flags relating to available mode HERE
//		try{
//			BasePage.cleanUpACCCMAvailableMode();
//		}catch(Exception ex){
//			// TODO Auto-generated catch block
//		
//		}

				
	/*	try{

			if (System.getProperty("os.name").startsWith("Windows"))
			{
				Utility.captureBitmap(logPath + "\\" + picPath);

			}
			else if (System.getProperty("os.name").startsWith("Mac"))
			{
				Utility.captureBitmap(logPath + "//" + picPath);
			}
			
		}catch(Exception ex){
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}*/
		
		
		/*
		 * Will be enhanced if can't get full of stack trace
		 */
        try {
            Utility.addLogfile(Constants.currentLogger, "================================"
                    + "\r\n [TEST CASE STATUS] FAILED\r\n" +
                    "================================"
            );

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
/*		//Update Report
		XMLReport xmlReport =  new XMLReport();
	    try {
			xmlReport.updateXmlReport(getTestClass(tr.getMethod().toString()), "Failed");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    }


    @Override
    public void onTestSkipped(ITestResult tr) {

        Log log;

//		//Clean up all flags relating to available mode HERE
//		try{
//			BasePage.cleanUpACCCMAvailableMode();
//		}catch(Exception ex){
//			// TODO Auto-generated catch block
//		
//		}
		
	/*
		try{
			
			String tcid = getTestClass(tr.getMethod().toString());
			log = Utility.createLog(tcid);
						
			//Capture bitmap
			String logPath = Constants.TCIDPath;
			String picPath = getTestClass(tr.getMethod().toString()) + "_Failed";
			if (System.getProperty("os.name").startsWith("Windows"))
			{
				Utility.captureBitmap(logPath + "\\" + picPath);

			}
			else if (System.getProperty("os.name").startsWith("Mac"))
			{
				Utility.captureBitmap(logPath + "//" + picPath);
			}

			
		}catch(Exception ex){
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
			*/
		/*
		 * Will be enhanced if can't get full of stack trace
		 */

        try {
            Utility.addLogfile(Constants.currentLogger, "================================"
                    + "\r\n [TEST CASE STATUS] FAILED\r\n" +
                    "================================"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	/*	//Update Report
		XMLReport xmlReport =  new XMLReport();
	    try {
			xmlReport.updateXmlReport(getTestClass(tr.getMethod().toString()), "Failed");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    }


    @Override
    public void onTestSuccess(ITestResult tr) {

//		//Clean up all flags relating to available mode HERE
//		try{
//			BasePage.cleanUpACCCMAvailableMode();
//		}catch(Exception ex){
//			// TODO Auto-generated catch block
//		
//		}


        try {
            Utility.addLogfile(Constants.currentLogger, "================================"
                    + "\r\n [TEST CASE STATUS] PASSED\r\n" +
                    "================================"
            );
        } catch (Exception e1) {
            e1.printStackTrace();
        }
/*
		//Update Report
		XMLReport xmlReport =  new XMLReport();
	    try {
			xmlReport.updateXmlReport(getTestClass(tr.getMethod().toString()), "Passed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
	
	
	/*
	*//**
     * When the suite started.
     * @param testContext Test context
     *//*
	  public final void onStart(final ITestContext testContext){
	  XmlSuite suite = testContext.getSuite().getXmlSuite();
	 
	  
	  *//*
	   * Backup Test Bed File 
	   *//*
	  if(Constants.backupTestBedFile == false){
		  InputStream inStream = null;
		  OutputStream outStream = null;
		 
		    	try{
		 
		    	    File afile =new File(Constants.TESTBED_FILE_PATH);
		    	    File bfile =new File(Constants.BTESTBED_FILE_PATH);
		 
		    	    inStream = new FileInputStream(afile);
		    	    outStream = new FileOutputStream(bfile);
		 
		    	    byte[] buffer = new byte[1024];
		 
		    	    int length;
		    	    //copy the file content in bytes 
		    	    while ((length = inStream.read(buffer)) > 0){
		 
		    	    	outStream.write(buffer, 0, length);
		 
		    	    }
		 
		    	    inStream.close();
		    	    outStream.close();
		 
		    	    Constants.backupTestBedFile = true; // Already backup
		    	    		
		    	    System.out.println("File is copied successful!");
		 
		    	}catch(IOException e){
		    		e.printStackTrace();
		    	}	
		    	
//		    	try{
//			    	//Minimize all applications
//			    	Robot keyBoard = new Robot();
//					keyBoard.keyPress(KeyEvent.VK_WINDOWS);
//					Thread.sleep(200);
//					keyBoard.keyPress(KeyEvent.VK_M);
//					Thread.sleep(200);
//					keyBoard.keyRelease(KeyEvent.VK_WINDOWS);
//					keyBoard.keyRelease(KeyEvent.VK_M);
//					Thread.sleep(1000);
//		    	}catch(Exception ex){
//		    		
//		    	}
	  }

	  
	  *//*
	   Method onStart is called when TestSet initialize all test classes which were declared inside it
	   Still haven't created test suite folder or creating a new test suite folder
	  *//*
	  if((Constants.numberCreateTSFolder == 0 )|| (!suite.getName().equals(Constants.currentTSName))) {
		  
		  	  String testSuitePath;
			  
		  	  *//*
		  	   * Update the name of current test suite
		  	   *//*
		  	  Constants.currentTSName = suite.getName();
		      	  
		  	  
		  	  *//*
		  	  if(Constants.inputTestBedData == 0) {
				  //Input data of testbed  
				  try {
					inputTestBedData(testContext);
					Constants.inputTestBedData = 1;
				  } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				  }  
			  }*//*
			   
			 
		  	  *//*
		  	   * Create Test Suite Folder
		  	   *//*
			   testSuitePath = createTestSuiteFolder(suite);
			    		       
			    
			    //Create xml report
			    XMLReport xmlReport =  new XMLReport();
			    try {
					xmlReport.createXmlReport(testContext);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    Constants.numberCreateTSFolder = 1;
		      
	  }	  
		super.onStart(testContext);
	  }
	  
	*/

    /**
     * Create and return test suite folder's path
     *
     * @param suite
     * @return String
     */
    public String createTestSuiteFolder(XmlSuite suite) {
        String testSuitePath = "";
        try {
            testSuitePath = Constants.reportFolder + suite.getName() + "_" + Utility.getDate();
            if (!Utility.createFolder(testSuitePath)) {
                testSuitePath = Constants.reportFolder + suite.getName() + "_" + Utility.getDate() + "_" + Utility.getTime();
                Utility.createFolder(testSuitePath);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Constants.suitePath = testSuitePath;
        return testSuitePath;
    }


    /**
     * Return the class'name
     */
    public String getTestClass(String name) {
        String[] arr = name.trim().split("\\.");
        return arr[0];
    }


//	public void inputTestBedData(ITestContext tx) throws Exception{
//	 
//		Hashtable testbedData = new Hashtable();
//		String[] row = null;
//		String csvFilename = "D:\\A3CMAutoTest\\TestData\\TestBed\\TestBed1.csv";
//		CSVReader csvReader = new CSVReader(new FileReader(csvFilename), ',', '\t', 1); 
//		List content = csvReader.readAll();
//		 for (Object object : content) {
//		    row = (String[]) object;
//		    testbedData.put(row[0].trim(), row[1].trim());
//		}
//		csvReader.close();
//		Constants.testbedData = testbedData;
//	}

}
