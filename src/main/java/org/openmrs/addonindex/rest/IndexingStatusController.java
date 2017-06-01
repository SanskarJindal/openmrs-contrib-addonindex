/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.addonindex.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openmrs.addonindex.service.IndexingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexingStatusController {
	
	private IndexingService service;
	
	@Autowired
	public IndexingStatusController(IndexingService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/v1/indexingstatus")
	public Map<String, Object> checkStatus() throws Exception {
		Map<String, Object> ret = new LinkedHashMap<>();
		ret.put("toIndex", service.getAllToIndex());
		ret.put("statuses", service.getIndexingStatus().getStatuses());
		return ret;
	}
	
}
