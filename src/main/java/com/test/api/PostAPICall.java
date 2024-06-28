package com.test.api;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class PostAPICall {
    public static void main(String[] args) {
        try {
            call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void call() throws Exception{
        String XMLSRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.spftl.com/integration/webservice\">" +
                "   <soapenv:Header>" +
                "      <web:Credentials>" +
                "         <ChannelId>SPS</ChannelId>" +
                "         <UserId>USER3</UserId>" +
                "         <Password>pass343</Password>" +
                "      </web:Credentials>" +
                "   </soapenv:Header>" +
                "   <soapenv:Body>" +
                "      <web:PostTransaction>" +
                "         <PostTransactionRequest>" +
                "            <ReferenceNo>SSSS30001</ReferenceNo>" +
                "            <ReferenceDate>2023-10-31</ReferenceDate>" +
                "            <OrigBrnCode>26</OrigBrnCode>" +
                "            <BatchNarration>Test Transaction Batch</BatchNarration>" +
                "            <Debits>" +
                "               <Debit>" +
                "               " +
                "                  <GlAccCode>146101101</GlAccCode>" +
                "                  " +
                "                  <GlBrnCode>26</GlBrnCode>" +
                "                  " +
                "                  <Amount>399</Amount>" +
                "                 " +
                "                  <Narration>GL Debit</Narration>" +
                "                  " +
                "                  " +
                "               </Debit>" +
                "            </Debits>" +
                "            <Credits>" +
                "" +
                "               <Credit>" +
                "                  " +
                "                  " +
                "                 <AccountNumber>0002634313507</AccountNumber>" +
                "                  " +
                "                  " +
                "                  <Amount>399</Amount>" +
                "                  " +
                "                  " +
                "                  " +
                "                  <Narration>Account Credit</Narration>" +
                "                " +
                "               </Credit>" +
                "            </Credits>" +
                "         </PostTransactionRequest>" +
                "      </web:PostTransaction>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        String url = "http://10.64.30.5:9090/integration/api/ws";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

// add request header
        con.setRequestMethod("POST");
        //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/xml; charset=utf-8");

// Send post request
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream(); //get output Stream from con
        os.write( XMLSRequest.getBytes("utf-8") );
        //System.out.println(os.toString());
        //os.flush();
        //System.out.println(con.getResponseMessage());
        os.close();

        String responsestatus = con.getResponseMessage();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputline;
        StringBuffer response = new StringBuffer();
        while ((inputline = in.readLine()) != null) {
            response.append(inputline);
        }
        in.close();
        System.out.println("response:" + response.toString());
    }
}
