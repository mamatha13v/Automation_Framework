package DriverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Utilities.ExcelFileUtil;
import CommonFunLibrary.FunctionLibrary;
import Constant.PBConstant;

public class KeywordDriverScript {
	String inputpath="/Users/user/eclipse-workspace/Automation_Frameworks/TestInput/Controller.xlsx";
	String outputpath="/Users/user/eclipse-workspace/Automation_Frameworks/TestOutput/KeywordResults.xlsx";
	String TCSheet="TestCases";
	String TSSheet="TestSteps";
	@Test
	public void startTest()throws Throwable
	{
		boolean res =false;
		String tcres="";
		//accessing excel methods
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no of rows in TCSheet
		int TCCount =xl.rowCount(TCSheet);
		//count no of rows in TSSheet
		int TSCount =xl.rowCount(TSSheet);
		Reporter.log("No of rows in TCSheet::"+TCCount+"  "+"No of rows in TSSheet::"+TCCount,true);
		//iterate all rows in TCSheet
		for(int i=1; i<=TCCount; i++)
		{
			//read execute cell
			String Execute =xl.getCellData(TCSheet, i, 2);
			if(Execute.equalsIgnoreCase("Y"))
			{
			//read tcid cell
				String tcid =xl.getCellData(TCSheet, i, 0);
				//iterate all rows in TSSheet
				for(int j=1; j<=TSCount; j++)
				{
					//read tsid cell
					String tsid = xl.getCellData(TSSheet, j, 0);
					if(tcid.equalsIgnoreCase(tsid))
					{
						//get keyword cell
						String keyword = xl.getCellData(TSSheet, j, 3);
						if(keyword.equalsIgnoreCase("AdminLogin"))
						{
							res=FunctionLibrary.verifyLogin("Admin", "Admin");
						}
						else if(keyword.equalsIgnoreCase("NewBranchCreation"))
						{
							FunctionLibrary.clickBranches();
							res=FunctionLibrary.verifyNewBranch("Kadiri", "Anantapur", "Madanapalli", "Tanakal", "Kadiri", "23456", "UK", "England", "LONDON");
						}
						else if(keyword.equalsIgnoreCase("UpdateBranch"))
						{
							FunctionLibrary.clickBranches();
							res=FunctionLibrary.verifyBranchUpdate("Kukatpalli", "Hyderabad", "98765");
						}
						else if(keyword.equalsIgnoreCase("AdminLogout"))
						{
							res=FunctionLibrary.verifyLogout();
						}
						String tsres="";
						if(res)
						{
							//if res true write as pass into results cell
							tsres="Pass";
							xl.setCellData(TSSheet, j, 4, tsres, outputpath);
						}
						else
						{
							//if res false write as fail into results cell
							tsres="fail";
							xl.setCellData(TSSheet, j, 4, tsres, outputpath);
						}
						tcres = tsres;
					}
				}
				//write as tcres into TCSheet
				xl.setCellData(TCSheet, i, 3, tcres, outputpath);
			}
			else
			{
				//write as blocked into status cell in TCSheet
				xl.setCellData(TCSheet, i, 3, "Blocked", outputpath);
			}
		}
	}
	}


