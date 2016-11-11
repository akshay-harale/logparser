package com.datatorrent.contrib.parser.log;

import com.datatorrent.api.Context;
import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.DefaultOutputPort;
import com.datatorrent.common.util.BaseOperator;
import com.datatorrent.contrib.parser.log.defaultlogs.pojo.DefaultLogs;
import com.datatorrent.contrib.parser.log.defaultlogs.pojo.Log;

import java.util.regex.Pattern;

/**
 * Created by synerzip on 20/10/16.
 */
public class LogParser extends BaseOperator {

    private String logType;
    private String pattern;
    private String logFormat;
    private Log log;
    private String schema;

    @Override
    public void setup(Context.OperatorContext context) {
        //define log type and pojo class
        log= DefaultLogs.logTypes.get(logType);
        super.setup(context);
        //get json schema and set the fields and regex
    }
    // Now create matcher object.

    final transient DefaultInputPort<byte[]> inputPort=new DefaultInputPort<byte[]>(){

        @Override
        public void process(byte[] bite) {
            //String line = "[03/Dec/2013:10:53:59 +0000] - [32002 10.102.4.254 195.229.241.182 Up24RwpmBAwAAA1LWJsAAAAR GET /content/dam/original.jpg HTTP/1.1] __utmc=94539802; dtCookie=EFD9D09B6A2E1; dtPC=load_; Carte::Kertdomain=6701c1320dd99722; UserData=Username%3ALSHARMA%3AHomepageg%3A0; UserID=1375493%de%3Aae; USER_DATA=rma%40landmain%3A13860608699722; MODE=FONTIS; __utma=945326.5609.190; __utmz=94ic|utmcomain.com%2F,; __ktv=28e8-6c4-be3-ce54137d9e48271; WT_FPC=id=2.50480.30226245:lv=1386047044279:ss=1386046439530; _opt_vi_3FNG8DZU=42880957-D2F1-4DC5-AF16-FEF88891D24E; __hstc=145721067.750d315a49c64268192826b3911a4e5a.1351772962050.1381151113005.1381297633204.66; hsfirstvisit=http%3A%2F%2Fwww.domain.com%2F|http%3A%2F%2Fwww.google.co.in%2Furl%3Fsa%3Dt%26rct%3Dj%26q%3Ddomain.com%26source%3Dweb%26cd%3D1%26ved%3D0CB0QFjAA%26url%3Dhttp%3A%2F%2Fwww.domain.com%2F%26ei%3DDmuSULW3AcTLhAfJ24CoDA%26usg%3DAFQjCNGvPmmyn8Bk67OUv-HwjVU4Ff3q1w|1351772962000; hubspotutk=750d315a49c64268192826b3911a4e5a; __ptca=145721067.jQ7lN5U3C4eN.1351758562.1381136713.1381283233.66; __ptv_62vY4e=jQ7lN5U3C4eN; __pti_62vY4e=jQ7lN5U3C4eN; __ptcz=145721067.1351758562.1.0.ptmcsr=google|ptmcmd=organic|ptmccn=(organic)|ptmctr=domain.com; RM=Lsharma%3Ac163b6097f90d2869e537f95900e1c464daa8fb9; wcid=Up2cRApmBAwAAFOiVhcAAAAH%3Af32e5e5f5b593175bfc71af082ab26e4055efeb6; __utmb=94539802.71.9.1386067462709; edge_auth=ip%3D195.229.241.182~expires%3D1386069280~access%3D%2Fapps%2F%2A%21%2Fbin%2F%2A%21%2Fcontent%2F%2A%21%2Fetc%2F%2A%21%2Fhome%2F%2A%21%2Flibs%2F%2A%21%2Freport%2F%2A%21%2Fsection%2F%2A%21%2Fdomain%2F%2A~md5%3D5b47f34172392487dcd44c1d837e2e54; has_js=1; SECTION=%2Fcontent%2Fsection%2Finspiration-design%2Fstreet-shots.html; JSESSIONID=b9377099-7708-45ae-b6e7-c575ffe82187; WT_FPC=id=2.50.27.157-3067016480.30226245:lv=1386053618209:ss=1386053618209; USER_GROUP=LSharma%3Afalse; NSC_wtfswfs_xfcgbsn40-41=ffffffff096e1a1d45525d5f4f58455e445a4a423660 200 \"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)\" \"www.domain.com\" - 24516 http://www.domain.com/content/report/Street_Shots/Youth/Global_round_up/2013/01_Jan/mens_youth_stylingglobalround-up1.html";
            String tuple=new String(bite);
            if(logFormat.equals("default")) {
                //get default log type
                Log pojo = log.getPojo(tuple);
                outputPort.emit(pojo);
            }
            else {
                //get string
                //get regex and parse the string using regex
                //parse schema to get the field names and regex.

            }

        }
    };

    private String createJsonFromLog(String tuple) {
        //get the type of log then create json for that log.


        //we need log type, schema
        //if it is default the use existing log schema,

        return null;
    }

    final transient DefaultOutputPort<Object> outputPort= new DefaultOutputPort<>();
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }
    public String getLogFormat() {
        return logFormat;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
