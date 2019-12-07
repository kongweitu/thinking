package com.boot.thinking.time;

import com.boot.thinking.LdmMapper1;
import com.boot.thinking.entity.LdmContent;
import com.boot.thinking.entity.Student;
import com.boot.thinking.utils.LdmParseUtil;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KdmAndLdmTest {
    @Resource
    private LdmMapper1 ldmMapper1;
    @Test
    public void test(){
        /*Student result1 = this.ldmMapper1.queryStudentTest("0001");
        LocalDateTime time = result1.getSage();
        System.out.println(time);*/
       /* SAXReader reader = new SAXReader();
        Integer result =0;
        Document document = null;
        try {
            document = reader.read("E:\\git\\src\\main\\resources\\ldm.xml");

            String xml = document.asXML();
            Map map = LdmParseUtil.parse(xml);
            String cplUuid = (String)map.get("cplUuid");
            String intervalBegin =(String) map.get("notValidBefore");
            String intervalEnd =(String) map.get("notValidAfter");
            String cpLContentTitleText=(String) map.get("PublicKeyAnnotationText");
            String ldmUuid =(String) map.get("ldmUuid");
            String dnQualifie =(String) map.get("dnQualifier");
           // log.info("ldmUuid:"+ldmUuid);
            Integer sum = (Integer)map.get("PlaybackCount");
            String playbackCount =String.valueOf(sum);
           // String fileName = StringUtils.substringAfterLast(ldmUrl,"/");
            String base64KDM = Base64.getEncoder().encodeToString(xml.getBytes("UTF-8"));
            LdmContent ldmContent = new LdmContent();
            ldmContent.setCplContentTitleText(cpLContentTitleText);
            ldmContent.setLdmIntervalBegin(intervalBegin);
            ldmContent.setLdmIntervalEnd(intervalEnd);
            ldmContent.setLdmUuid(ldmUuid);
            //ldmContent.setFilmName(filmName);
            ldmContent.setKdmXml(base64KDM);
            //ldmContent.setLdmUrl(ldmUrl);
            ldmContent.setX509Subjectname(dnQualifie);
            String cinemaName = "实验室CFGDC";
            ldmContent.setRequestCinema(cinemaName);
            ldmContent.setLdmSum(playbackCount);
            ldmContent.setDistributetype("自动");
            //ldmContent.setDeviceSn(devicesn);
            ldmContent.setCplUuid(cplUuid);
            ldmMapper1.saveLdm(ldmUuid,base64KDM);

        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

}
