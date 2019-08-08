/*
 *    Copyright (c) 2018-2025, Eddid All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: Eddid (River.lu@newtype.io)
 */

package com.postgres.codegen.controller;

import cn.hutool.core.io.IoUtil;
import com.postgres.codegen.config.GenerateProperties;
import com.postgres.codegen.entity.dto.GenCodeLikeVo;
import com.postgres.codegen.entity.dto.GenCodeVo;
import com.postgres.codegen.service.SysGeneratorService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 代码生成器
 *
 * @author Eddid
 * @date 2018-07-30
 */
@RestController
@RequestMapping("/generator")
@AllArgsConstructor
public class SysGeneratorController {
	private final GenerateProperties generateProperties;

	@Autowired
	private SysGeneratorService sysGeneratorService;

	/**
	 * 生成代码
	 */
	@SneakyThrows
	@PostMapping("/tableNames")
	public void generatorByTableNames(@RequestBody GenCodeVo genCodeVo, HttpServletResponse response) {
		byte[] data = sysGeneratorService.generatorByTableNames(genCodeVo);

		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genCodeVo.getPackageName()));
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");

		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}

	/**
	 * 模糊生成代码
	 */
	@SneakyThrows
	@PostMapping("/tableNameLike")
	public void generatorByTalbleNameLike(@RequestBody GenCodeLikeVo genCodeLikeVo, HttpServletResponse response) {
		byte[] data = sysGeneratorService.generatorByTalbleNameLike(genCodeLikeVo);

		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genCodeLikeVo.getPackageName()));
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");

		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}
}
