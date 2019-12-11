package com.boot.thinking;

import com.boot.thinking.entity.LdmContent;
import com.boot.thinking.entity.Student;
import com.boot.thinking.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LdmMapper1 {
    public Integer updateLdmContentStatus(LdmContent ldmContent);

    public User queryUser();

    public void saveLdm(@Param("ldmUuid") String ldmUuid,@Param("kdmXml") String kdmXml)throws Exception;
    @Insert("insert into student (SId,Sage) values (#{sId},#{sage})")
    public Integer insertStudentTest(Student student);
    @Select("select * from student where SId = #{id}")
    public Student queryStudentTest(String id);
}

