package com.meng.anjia.util;

/**
 * @author yue
 * @date  2019/3/18
 */
public class RedisKeyUtil {
    private RedisKeyUtil() {
    }

    private static final String SPLIT = ":";
    private static final String BIZ_LIKE = "LIKE";
    private static final String BIZ_DISLIKE = "DISLIKE";
    private static final String BIZ_EVENTQUEUE = "EVENT_QUEUE";
    /**
     * 获取粉丝
     */
    private static final String BIZ_FOLLOWER = "FOLLOWER";
    /**
     * 关注对象
     */
    private static final String BIZ_FOLLOWEE = "FOLLOWEE";

    private static final String BIZ_TIMELINE = "TIMELINE";
    /**
     * LIKE:entityType:entityId
     * @param entityType
     * @param entityId
     * @return
     */
    public static String getLikeKey(int entityType, int entityId) {
        return BIZ_LIKE + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    /**
     * DISLIKE:entityType:entityId
     * @param entityType
     * @param entityId
     * @return
     */
    public static String getDisLikeKey(int entityType, int entityId) {
        return BIZ_DISLIKE + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    /**
     * 某个实体的粉丝们
     * @param entityType
     * @param entityId
     * @return
     */
    public static String getFollowerKey(int entityType, int entityId) {
        return BIZ_FOLLOWER + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    /**
     * 某个用户关注的某类实体们
     * @param userId
     * @param entityType
     * @return
     */
    public static String getFolloweeKey(int userId, int entityType) {
        return BIZ_FOLLOWEE + SPLIT + String.valueOf(userId) + SPLIT + String.valueOf(entityType);
    }

    public static String getEventQueueKey() {
        return BIZ_EVENTQUEUE;
    }

    /**
     * TIMELINE:[userID]
     * @param userId
     * @return
     */
    public static String getTimelineKey(int userId) {
        return BIZ_TIMELINE + SPLIT + String.valueOf(userId);
    }
}
