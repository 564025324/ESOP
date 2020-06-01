package com.ecs.datacheck;

public class AppraisalFinishCheck {

	/**
	 * 是否存在[已认定完成未写入同步表的数据]校验Sql语句
	 * 
	 * @param args
	 */
	public String SqlText() {
		String sql = "	select a.new_name\r\n" + "		   ,b.new_equipmentidName\r\n"
				+ "		   ,a.new_appraisalfinishtime \r\n" + "		   ,b.lastupdatetime\r\n"
				+ "	from ecsp_MSCRM..new_obfapplication a\r\n" + "	left join (\r\n"
				+ "			select * ,ROW_NUMBER() over(partition by new_name order by lastupdatetime desc ) as oid\r\n"
				+ "			from epson..IF_OBF_SYNC_ECSTOEFR \r\n"
				+ "		) b on b.oid=1 and a.new_name = b.new_name\r\n"
				+ "	where a.new_appraisalfinishtime is not null\r\n" + "	and b.lastupdatetime is null";
		return sql;
	}

	public static void main(String[] args) {

	}

}
