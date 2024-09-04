package com.jatin.user_profile.service;

import java.util.HashMap;
import java.util.Map;

import com.jatin.user_profile.model.UserProfile;

/**
 * UserProfileService
 */
public class UserProfileService {

    private final Map<String, UserProfile> userProfiles = new HashMap<>();

    public boolean createUserProfile(String userId, UserProfile userProfile) {
        if (userProfiles.containsKey(userId)) {
            return false;
        }
        userProfiles.put(userId, userProfile);
        return true;
    }

    public UserProfile getUserProfile(String userId) {
        return userProfiles.get(userId);
    }

    public boolean updateUserProfile(String userId, UserProfile updatedProfile) {
        if (!userProfiles.containsKey(userId)) {
            return false;
        }
        userProfiles.put(userId, updatedProfile);
        return true;
    }

    public boolean deleteUserProfile(String userId) {
        return userProfiles.remove(userId) != null;
    }
}
