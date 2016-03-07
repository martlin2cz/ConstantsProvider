package cz.martlin.cptesting;

import java.math.BigDecimal;
import java.util.Date;

import cz.martlin.cp.CP;

/**
 * Some another testing class.
 * 
 * @author martin
 *
 */
public class AdminUserData {
	private final String USER_NAME = CP.string().create("admin_name", "admin");
	private final BigDecimal PASS_HASH = CP.bigDecimal().parse("password_hash", "123465789");
	private final Date EXPIRES_AT = CP.date().create("expires", new Date());

	private Date lastLoggedAt;
	private String name;

	public AdminUserData() {
	}

	public Date getLastLoggedAt() {
		return lastLoggedAt;
	}

	public void setLastLoggedAt(Date lastLoggedAt) {
		this.lastLoggedAt = lastLoggedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public BigDecimal getPASS_HASH() {
		return PASS_HASH;
	}

	public Date getEXPIRES_AT() {
		return EXPIRES_AT;
	}

	@Override
	public String toString() {
		return "AdminUserData [USER_NAME=" + USER_NAME + ", PASS_HASH=" + PASS_HASH + ", EXPIRES_AT=" + EXPIRES_AT
				+ ", lastLoggedAt=" + lastLoggedAt + ", name=" + name + "]";
	}

}
