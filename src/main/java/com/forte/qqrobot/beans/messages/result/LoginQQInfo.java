package com.forte.qqrobot.beans.messages.result;

/**
 * 登录的QQ的信息
 * @author ForteScarlet <[163邮箱地址]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public interface LoginQQInfo extends InfoResult {

    /** 昵称 */
    String getName();
    /**
     * QQ号
     * @see #getCode()
     */
    String getQQ();

    /** 将会取代方法：getQQ()  */
    default String getCode(){
        return getQQ();
    }


    /** 头像地址 */
    String getHeadUrl();
    /** 等级 */
    Integer getLevel();

}
