package cz.martlin.cp.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread, which waits given time and then exports created constants' defaults
 * values list.
 * 
 * @author martin
 *
 */
public class ExportThread extends Thread {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private final ConstantsList list;
	private final int timeout;

	public ExportThread(ConstantsList list, int timeout) {
		super("ExportT");

		this.list = list;
		this.timeout = timeout;
	}

	@Override
	public void run() {
		log.info("Waiting [{}] ms and then exports", timeout);
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			log.error("Wait interrupted, will export now");
		}

		list.save();

		log.info("Constants exported.");
	}

}
