package com.boot.thinking.utils;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.XPath;

import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Logger;

public class LdmParseUtil {

    /****
     * 加载LDM(计次密钥）
     * @param kdmXml
     * @return
     */
    public static Map<String,Object> parse(String kdmXml) {
        final  Map<String,Object> map  = new HashMap<>();
        Document document;
        try {
            document = DocumentHelper.parseText(kdmXml);
            Map<String, String> namespace_map = getLdmNameSpace(kdmXml);
            XPath x = document.createXPath("//ns:AuthenticatedPublic/ns:MessageId");
            x.setNamespaceURIs(namespace_map);
            map.put("ldmUuid",cutUuid(x.selectSingleNode(document).getText()));

                XPath x_ContentTitleText = document.createXPath("//ns:AuthenticatedPublic/ns:RequiredExtensions/ns4:LDMRequiredExtensions/ns4:ContentTitleText");
                x_ContentTitleText.setNamespaceURIs(namespace_map);
                map.put("ContentTitleText",x_ContentTitleText.selectSingleNode(document).getText());

                XPath x_X509SubjectName = document.createXPath("//ns:AuthenticatedPublic/ns:RequiredExtensions/ns4:LDMRequiredExtensions/ns4:Recipient/ns4:X509SubjectName");
                x_X509SubjectName.setNamespaceURIs(namespace_map);
                String result = x_X509SubjectName.selectSingleNode(document).getText();
                map.put("dnQualifier",getRecipientFromX509SubjectName(result));

                XPath x_PlaybackCount = document.createXPath("//ns:AuthenticatedPublic/ns:RequiredExtensions/ns4:LDMRequiredExtensions/ns4:PlaybackCount");
                x_PlaybackCount.setNamespaceURIs(namespace_map);
                Integer xp = new Integer(x_PlaybackCount.selectSingleNode(document).getText());
                map.put("PlaybackCount",xp);

            /*XPath x_CompositionPlaylistId = document.createXPath("//ns:AuthenticatedPublic/ns:RequiredExtensions/ns4:LDMRequiredExtensions/ns4:CompositionPlaylistId");
            x_CompositionPlaylistId.setNamespaceURIs(namespace_map);
            map.put("PlaybackCount",cutUuid(x_CompositionPlaylistId.selectSingleNode(document).getText()));*/
            XPath x_CompositionPlaylistId = document.createXPath("//ns:AuthenticatedPublic/ns:RequiredExtensions/ns4:LDMRequiredExtensions/ns4:CompositionPlaylistId");
            x_CompositionPlaylistId.setNamespaceURIs(namespace_map);
            map.put("cplUuid",cutUuid(x_CompositionPlaylistId.selectSingleNode(document).getText()));

            XPath ContentKeysNotValidBefore = document.createXPath("//ns:AuthenticatedPublic/ns:RequiredExtensions/ns4:LDMRequiredExtensions/ns4:ContentKeysNotValidBefore");
            ContentKeysNotValidBefore.setNamespaceURIs(namespace_map);
            Date notValidBefore = DatatypeFactory.newInstance().newXMLGregorianCalendar(ContentKeysNotValidBefore.selectSingleNode(document).getText()).toGregorianCalendar().getTime();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.ofInstant(notValidBefore.toInstant(), ZoneId.systemDefault());
            String notValidBefore1=df.format(localDateTime);
            map.put("notValidBefore",notValidBefore1);

            XPath ContentKeysNotValidAfter = document.createXPath("//ns:AuthenticatedPublic/ns:RequiredExtensions/ns4:LDMRequiredExtensions/ns4:ContentKeysNotValidAfter");
            ContentKeysNotValidAfter.setNamespaceURIs(namespace_map);
            Date notValidAfter = DatatypeFactory.newInstance().newXMLGregorianCalendar(ContentKeysNotValidAfter.selectSingleNode(document).getText()).toGregorianCalendar().getTime();
            LocalDateTime localDateTime1 = LocalDateTime.ofInstant(notValidAfter.toInstant(), ZoneId.systemDefault());
            String notValidAfter1 = df.format(localDateTime1);
            map.put("notValidAfter",notValidAfter1);
            //public keys

                XPath x_AnnotationText = document.createXPath("//ns:AuthenticatedPublic/ns:AnnotationText");
                x_AnnotationText.setNamespaceURIs(namespace_map);
                map.put("PublicKeyAnnotationText",x_AnnotationText.selectSingleNode(document).getText());


                XPath x_PublicKeyMessageId = document.createXPath("//ns:AuthenticatedPublic/ns:MessageId");
                x_PublicKeyMessageId.setNamespaceURIs(namespace_map);
                map.put("PublicKeyMessageId",x_PublicKeyMessageId.selectSingleNode(document).getText());

                XPath x_PublicKeyMessageType = document.createXPath("//ns:AuthenticatedPublic/ns:MessageType");
                x_PublicKeyMessageType.setNamespaceURIs(namespace_map);
                map.put("PublicKeyMessageType",x_PublicKeyMessageType.selectSingleNode(document).getText());

                XPath x_PublicKeyNonCriticalExtensions = document.createXPath("//ns:AuthenticatedPublic/ns:NonCriticalExtensions");
                x_PublicKeyNonCriticalExtensions.setNamespaceURIs(namespace_map);
                map.put("PublicKeyNonCriticalExtensions",x_PublicKeyNonCriticalExtensions.selectSingleNode(document).getText());

                XPath x_PublicKeySignerX509IssuerName = document.createXPath("//ns:AuthenticatedPublic/ns:Signer/ds:X509IssuerName");
                x_PublicKeySignerX509IssuerName.setNamespaceURIs(namespace_map);
                String issuerName = x_PublicKeySignerX509IssuerName.selectSingleNode(document).getText();
                map.put("PublicKeySignerX509IssuerName",issuerName);

                XPath x_PublicKeySignerX509SerialNumber = document.createXPath("//ns:AuthenticatedPublic/ns:Signer/ds:X509SerialNumber");
                x_PublicKeySignerX509SerialNumber.setNamespaceURIs(namespace_map);
                BigInteger d = new BigInteger(x_PublicKeySignerX509SerialNumber.selectSingleNode(document).getText());
                map.put("PublicKeySignerX509SerialNumber",d);

                XPath x_SignatureValue = document.createXPath("//ds:Signature/ds:SignatureValue");
                x_SignatureValue.setNamespaceURIs(namespace_map);
                String xs = x_SignatureValue.selectSingleNode(document).getText();
                map.put("SignatureValue",xs.getBytes());

                XPath x_PrivateKeys = document.createXPath("//ns:AuthenticatedPrivate/enc:EncryptedKey/enc:CipherData/enc:CipherValue");
                x_PrivateKeys.setNamespaceURIs(namespace_map);
                List<Node> selectNodes = x_PrivateKeys.selectNodes(document);
                List<byte[]> xss = new ArrayList<byte[]>();
                for (Node node : selectNodes) {
                    xss.add(node.getText().getBytes());
                }
                map.put("PrivateKeys",xss);


            document.clearContent();
            document = null;
        } catch (Exception e1) {
        }
        return map;
    }
    /****
     * 获取计时密钥的命名空间
     * @param xmlns
     * @return
     */
    private static Map<String, String>  getLdmNameSpace(String kdmXml){
        Map<String,String> ns1=new HashMap<String,String>();
        if (isSMPTE(kdmXml)) {
            ns1.put("ns", "http://www.smpte-ra.org/schemas/430-3/2006/ETM");
            ns1.put("ns4", "http://td.digifilm.com/schema/2015/LDM#");
            ns1.put("ds", "http://www.w3.org/2000/09/xmldsig#");
            ns1.put("enc", "http://www.w3.org/2001/04/xmlenc#");
        }else {
            ns1.put("ns", "http://www.digicine.com/PROTO-ASDCP-KDM-20040311#");
            ns1.put("ns4", "http://td.digifilm.com/schema/2015/LDM#");
            ns1.put("ds", "http://www.w3.org/2000/09/xmldsig#");
            ns1.put("enc", "http://www.w3.org/2001/04/xmlenc#");
        }
        return ns1;
    }
    public static boolean isSMPTE(String xml) {
        return xml.indexOf("www.smpte-ra.org") >= 0;
    }
    public static String cutUuid(String uuid) {
        if (uuid == null)
            return null;
        if (!uuid.startsWith("urn:uuid:")) {
            return uuid;
        }
        return uuid.substring(9);
    }
    /***
     * 从kdm xml的x509subejctname中提取recipient
     * @param x509SubjectName
     * @return
     */
    private static String getRecipientFromX509SubjectName(String x509SubjectName) {
        if (x509SubjectName == null) {
            return "";
        }
        x509SubjectName = x509SubjectName.substring(x509SubjectName.indexOf("dnQualifier=")+12);
        x509SubjectName = x509SubjectName.substring(0, x509SubjectName.indexOf("=")+1);
        x509SubjectName = x509SubjectName.replace("\\", "");
        return x509SubjectName;
    }
}
