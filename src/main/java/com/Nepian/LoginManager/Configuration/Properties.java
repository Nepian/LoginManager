package com.Nepian.LoginManager.Configuration;

import com.Nepian.Breeze.Configuration.Annotation.ConfigurationComment;
import com.Nepian.Breeze.Configuration.Annotation.PrecededBySpace;

public class Properties {
	@PrecededBySpace
	@ConfigurationComment("ユーザデータのパス名")
	public static String NAME_PATH = "Name";
	public static String EXP_PATH = "Exp";
}
