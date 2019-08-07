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

package com.postgres.codegen.service;

import com.postgres.codegen.entity.GenConfig;

import java.util.List;

/**
 * 代码生成器
 *
 * @author Eddid
 * @date 2019-05-20
 */
public interface SysGeneratorService {
	/**
	 * 批量生成代码
	 *
	 * @param genConfigs 表名称
	 * @return
	 */
	byte[] generatorCode(List<GenConfig> genConfigs);


	/**
	 * 批量模糊生成代码
	 *
	 * @param genConfig 表名称
	 * @return
	 */
	public byte[] generatorCodeLike(GenConfig genConfig);

}
