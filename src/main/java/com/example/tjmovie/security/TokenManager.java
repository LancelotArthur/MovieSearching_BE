package com.example.tjmovie.security;

/**
 * 对token进行操作的接口
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     */
    public TokenModel createToken(String userName);

    /**
     * 检查token是否有效
     * @return 是否有效
     */
    public boolean checkToken(TokenModel tokenModel);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public TokenModel getToken(String authentication);

    /**
     * 清除token
     */
    public void deleteToken(String userName);

}
