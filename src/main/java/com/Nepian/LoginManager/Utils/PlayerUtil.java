package com.Nepian.LoginManager.Utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.Nepian.Breeze.Utils.XpUtil;

public class PlayerUtil {
	public static final int MAX_EXP = 2100000000;

	/**
	 * プレイヤーのXPを取得する
	 * @param player XPを取得するプレイヤー
	 * @return プレイヤーから取得したXP
	 */
	public static int getXp(Player player) {
		return player.getLevel();
	}

	/**
	 * プレイヤーのEXPゲージの値を取得する
	 * @param player 値を取得するプレイヤー
	 * @return 取得した値
	 */
	public static float getExpPercentage(Player player) {
		return player.getExp();
	}

	/**
	 * プレイヤーのEXPを取得する
	 * @param player 取得対象のプレイヤー
	 * @return 取得したEXP
	 */
	public static int getExp(Player player) {
		int xp = getXp(player);
		float percentage = getExpPercentage(player);
		return XpUtil.convertXpToExp(xp) + XpUtil.convertExpPercentageToExp(xp, percentage);
	}

	/**
	 * プレイヤーのXPを設定する
	 * @param player 設定対象のプレイヤー
	 * @param xp 設定するXP量
	 * @return XPを設定したプレイヤー
	 */
	public static Player setXp(Player player, int xp) {
		player.setLevel(xp);
		return player;
	}

	/**
	 * プレイヤーのEXPゲージの値を設定する
	 * @param player 設定対象のプレイヤー
	 * @param percentage 設定する値
	 * @return EXPゲージの値を設定したプレイヤー
	 */
	public static Player setExpPercentage(Player player, float percentage) {
		player.setExp(percentage);
		return player;
	}

	/**
	 * プレイヤーのEXP総量を設定する
	 * @param player 設定対象のプレイヤー
	 * @param exp 設定するEXP
	 * @return EXP総量を設定したプレイヤー
	 */
	public static Player setTotalExp(Player player, int exp) {
		player.setTotalExperience(exp);
		return player;
	}

	/**
	 * プレイヤーのEXPを設定する
	 * @param player 設定対象のプレイヤー
	 * @param exp 設定するEXP量
	 * @return EXPを設定したプレイヤー
	 */
	public static Player setExp(Player player, int quantity) {
		int exp = Math.min(MAX_EXP, Math.max(0, quantity));
		int xp = XpUtil.convertExpToXp(exp);

		float expPercentage = (float) (exp - XpUtil.convertXpToExp(xp))
				/ (float) XpUtil.getExpNeededToLevelUp(xp);

		setTotalExp(player, exp);
		setXp(player, xp);
		setExpPercentage(player, expPercentage);

		return player;
	}

	/**
	 * プレイヤーの次のレベルアップまでに必要な残りのEXPを取得する
	 * @param player 取得対象のプレイヤー
	 * @return レベルアップまでに必要な残りのEXP
	 */
	public static int getRestExpNeededToLevelUp(Player player) {
		int xp = getXp(player);
		int exp = getExp(player);
		return XpUtil.convertXpToExp(xp + 1) - exp;
	}

	/**
	 * プレイヤーの次のレベルまでに必要なEXPを取得する
	 * @param player 取得対象のプレイヤー
	 * @return 次のレベルまでに必要なEXP
	 */
	public static int getExpNeededForNextLevel(Player player) {
		return XpUtil.getExpNeededToLevelUp(getXp(player));
	}

	/**
	 * プレイヤーの指定したXP差分のEXPを取得する
	 * @param player
	 * @param diff
	 * @return
	 */
	public static int getExpXpToXp(Player player, int diff) {
		int xp = getXp(player);
		return XpUtil.getExpXpToXp(xp + diff, xp);
	}

	/**
	 * プレイヤーにEXPを追加する
	 * @param player 追加対象のプレイヤー
	 * @param quantity 追加するEXP量
	 * @return EXPを変更したプレイヤー
	 */
	public static Player addExp(Player player, int quantity) {
		return setExp(player, getExp(player) + quantity);
	}

	/**
	 * プレイヤーのEXPを0にする
	 * @param player 対象のプレイヤー
	 * @return EXPを0にしたプレイヤー
	 */
	public static Player clearExp(Player player) {
		return  setExp(player, 0);
	}

	/**
	 * UUIDからプレイヤーの名前を取得
	 * @param uuid 対象のUUID
	 * @return String 存在しない場合は、nullを返す
	 */
	public static String getName(UUID uuid) {
		for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			if (player.getUniqueId().equals(uuid)) {
				return player.getName();
			}
		}

		return null;
	}

	/**
	 * プレイヤー名からUUIDを取得
	 * @param name 対象のプレイヤー名
	 * @return UUID 存在しない場合は、nullを返す
	 */
	public static UUID getUUID(String name) {
		for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			if (player.getName().equals(name)) {
				return player.getUniqueId();
			}
		}

		return null;
	}
}
