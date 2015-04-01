package com.lankbank_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import com.lankbank_file.Entity.DataEntity;
import com.lankbank_file.Entity.OutEntity;

public class CreateData
{
    private List<DataEntity> datas=new ArrayList<DataEntity>();
    private List<OutEntity> outdatas=new ArrayList<OutEntity>();
    private String outputLine=new String();
    private File outFile=null;
    private Calendar cal=Calendar.getInstance();
    private int day=cal.get(Calendar.DATE);
    private int month=cal.get(Calendar.MONTH)+1;
    private int year=cal.get(Calendar.YEAR);
    private String time=Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);

    public CreateData(List<DataEntity> getDatas)
    {
	datas=getDatas;
    }

    public void CreateOutData() throws IOException
    {
	for(DataEntity input : datas)
	{
	    OutEntity output1=new OutEntity();
	    InsertFireData(output1,input);
	    outdatas.add(output1);
	    OutEntity output2=new OutEntity();
	    InsertFireData(output2,input);
	    output2.setTYPE("EI        ");
	    output2.setTYPE_DETAIL("EI        ");
	    output2.setCOMI_RATE("00.060");
	    output2.setPREM("000"+input.getEQ_PREM());
	    output2.setAMT("000"+input.getEQ_AMT());
	    outdatas.add(output2);
	}
	outFile=new File("D:\\土銀續保受理檔-"+time+".txt");
	outFile.createNewFile();
	PrintWriter writer=new PrintWriter(outFile,"MS950");

	for(OutEntity outfile : outdatas)
	{
	    outputLine=outfile.getCOMP()+outfile.getACCP_NO()+outfile.getPLY_NO()+outfile.getTYPE()+outfile.getTYPE_DETAIL()+outfile.getCOMM_DAY()+outfile.getEFF_DAY()+outfile.getEXP_DAY()+outfile.getSITU_TYPE()+outfile.getPLY_TYPE()+outfile.getCONTENT()+outfile.getRENEW()+outfile.getFASR_NAME()+outfile.getFASR_ID()+outfile.getAREA()+outfile.getADDR()+outfile.getCNAME()+outfile.getID()+outfile.getBIRTH()+outfile.getYEAR()+outfile.getFILLER()+outfile.getPREM()+outfile.getAMT()+outfile.getFILLER2()+outfile.getCOMI_RATE()+outfile.getFILLER1()+outfile.getAGENT_UNIT()+outfile.getAUTO()+outfile.getOVER()+outfile.getFILLER3()+outfile.getORG_PLY()+outfile.getORG_EXP()+outfile.getFILLER4()+outfile.getFILLER5();
	    writer.write(outputLine+"\n");
	}
	writer.close();
	JOptionPane.showMessageDialog(null,"轉檔完成");
    }

    public void InsertFireData(OutEntity output, DataEntity input)
    {
	output.setCOMP("108  ");
	output.setACCP_NO("08"+input.getPLY_NO()+"                    ");
	output.setPLY_NO("                         ");
	output.setTYPE("RFI       ");
	output.setTYPE_DETAIL("RFI       ");
	int issuday=Integer.valueOf(input.getISSU_DAY())+19110000;
	output.setCOMM_DAY(issuday);
	int neday=Integer.valueOf(input.getN_E_DAY())+19110000;
	output.setEFF_DAY(neday);
	int expday=Integer.valueOf(input.getEXP_DAY())+19110000;
	output.setEXP_DAY(expday);
	output.setSITU_TYPE("1");
	output.setPLY_TYPE("91");
	output.setCONTENT("                                                            ");
	output.setRENEW("1");
	output.setFASR_NAME(input.getFASR_NAME());
	output.setFASR_ID(input.getFASR_ID()+"  ");
	output.setAREA(input.getADDR_AREA());
	output.setADDR(input.getADDR()+"                    ");
	output.setCNAME(input.getINSURED()+"  ");
	output.setID(input.getID_NO()+"  ");
	output.setBIRTH("        ");
	output.setYEAR("   ");
	output.setFILLER("00");
	output.setPREM("000"+input.getBUILD_PREM());
	output.setAMT("000"+input.getBUILD_AMT());
	output.setFILLER2("1");
	output.setCOMI_RATE("00.169");
	output.setFILLER1("001");
	output.setAGENT_UNIT(input.getSEQ_NO().substring(0,3));
	output.setAUTO("0");
	output.setOVER("1");
	output.setFILLER3("                              ");
	output.setORG_PLY(input.getORG_PLY()+"               ");
	expday=Integer.valueOf(input.getEXP_DAY())+19100000;
	output.setORG_EXP(expday);
	output.setFILLER4(" ");
	output.setFILLER5(" ");
    }
}
