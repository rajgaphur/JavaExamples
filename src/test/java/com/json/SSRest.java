package com.json;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import io.restassured.path.xml.XmlPath;

public class SSRest
{
    public String market;
    public String timezone;
    public String dst_observed;
    public String fips;
    public String psapid;
    public String psapenabled;
    public String awsspectrumenabled;
    public String pcsspectrumenabled;
    public String mta;
    public String signalgsm;
    public String signalumts;
    public String signallte;
    public String msc_pool_region;
    public String mme_pool_name;
    public String mme_pool_id;
    public String state;
    public String county;
    public String rnc_id_s1gw_id_lac_tac_list1;
    public String rnc_id_s1gw_id_lac_tac_list2;
    public String rnc_id_s1gw_id_lac_tac_list3;
    public String rnc_id_s1gw_id_lac_tac_list4;
    public String rnc_id_s1gw_id_lac_tac_list5;
    public String rnc_id_s1gw_id_lac_tac_list6;
    public String rnc_id_s1gw_id_lac_tac_list7;
    public String rnc_id_s1gw_id_lac_tac_list8;
    public String nbiot_s1gwid_tac_list1;
    public String nbiot_s1gwid_tac_list2;
    public String nbiot_s1gwid_tac_list3;
    public String nbiot_s1gwid_tac_list4;
    public String nbiot_s1gwid_tac_list5;
    public String nbiot_s1gwid_tac_list6;
    public String nbiot_s1gwid_tac_list7;
    public String nbiot_s1gwid_tac_list8;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String postalcodebase;
    public String stateprovince;
    private String template;
    private String contents;
    public XmlPath soapXml;
    
    public SSRest() {
        this.template = null;
        this.contents = null;
        this.contents = this.template;
    }
    
    public SSRest(String fileName) {
        this.template = null;
        this.contents = null;
        this.readTemplateFile(fileName);
        this.contents = this.template;
    }
    
    public String getContents() {
        this.replaceParameters();
        return this.contents;
    }
    
    private void readTemplateFile(String fileName) {
        final StringBuilder result = new StringBuilder();
        try {
            final BufferedReader templateReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = templateReader.readLine()) != null) {
                if (line != null) {
                    result.append(String.valueOf(line) + "\n");
                }
            }
            this.template = result.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void replaceParameters() {
        this.replaceParameterValue("signalgsm", this.signalgsm);
        this.replaceParameterValue("signalumts", this.signalumts);
        this.replaceParameterValue("signallte", this.signallte);
        this.replaceParameterValue("pcsspectrumenabled", this.pcsspectrumenabled);
        this.replaceParameterValue("awsspectrumenabled", this.awsspectrumenabled);
        this.replaceParameterValue("psapid", this.psapid);
        this.replaceParameterValue("market", this.market);
        this.replaceParameterValue("timezone", this.timezone);
        this.replaceParameterValue("dst_observed", this.dst_observed);
        this.replaceParameterValue("mta", this.mta);
        this.replaceParameterValue("psapenabled", this.psapenabled);
        this.replaceParameterValue("msc_pool_region", this.msc_pool_region);
        this.replaceParameterValue("mme_pool_id", this.mme_pool_id);
        this.replaceParameterValue("fips", this.fips);
        this.replaceParameterValue("mme_pool_name", this.mme_pool_name);
        this.replaceParameterValue("county", this.county);
        this.replaceParameterValue("state", this.state);
        this.replaceParameterValue("nbiot_s1gwid_tac_list1", this.nbiot_s1gwid_tac_list1);
        this.replaceParameterValue("nbiot_s1gwid_tac_list2", this.nbiot_s1gwid_tac_list2);
        this.replaceParameterValue("nbiot_s1gwid_tac_list3", this.nbiot_s1gwid_tac_list3);
        this.replaceParameterValue("nbiot_s1gwid_tac_list4", this.nbiot_s1gwid_tac_list4);
        this.replaceParameterValue("nbiot_s1gwid_tac_list5", this.nbiot_s1gwid_tac_list5);
        this.replaceParameterValue("nbiot_s1gwid_tac_list6", this.nbiot_s1gwid_tac_list6);
        this.replaceParameterValue("nbiot_s1gwid_tac_list7", this.nbiot_s1gwid_tac_list7);
        this.replaceParameterValue("nbiot_s1gwid_tac_list8", this.nbiot_s1gwid_tac_list8);
        this.replaceParameterValue("rnc_id_s1gw_id_lac_tac_list1", this.rnc_id_s1gw_id_lac_tac_list1);
        this.replaceParameterValue("rnc_id_s1gw_id_lac_tac_list2", this.rnc_id_s1gw_id_lac_tac_list2);
        this.replaceParameterValue("rnc_id_s1gw_id_lac_tac_list3", this.rnc_id_s1gw_id_lac_tac_list3);
        this.replaceParameterValue("rnc_id_s1gw_id_lac_tac_list4", this.rnc_id_s1gw_id_lac_tac_list4);
        this.replaceParameterValue("rnc_id_s1gw_id_lac_tac_list5", this.rnc_id_s1gw_id_lac_tac_list5);
        this.replaceParameterValue("rnc_id_s1gw_id_lac_tac_list6", this.rnc_id_s1gw_id_lac_tac_list6);
        this.replaceParameterValue("rnc_id_s1gw_id_lac_tac_list7", this.rnc_id_s1gw_id_lac_tac_list7);
        this.replaceParameterValue("rnc_id_s1gw_id_lac_tac_list8", this.rnc_id_s1gw_id_lac_tac_list8);
        this.replaceParameterValue("addressLine1", this.addressLine1);
        this.replaceParameterValue("addressLine2", this.addressLine2);
        this.replaceParameterValue("city", this.city);
        this.replaceParameterValue("postalcodebase", this.postalcodebase);
        this.replaceParameterValue("stateprovince", this.stateprovince);
    }
    
    private void replaceParameterValue(String parameterName, String value) {
        this.contents = this.contents.replaceAll("%" + parameterName + "%", value);
    }
}
