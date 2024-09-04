package com.jatin.user_profile.servlet;

import java.io.IOException;

import com.jatin.user_profile.model.UserProfile;
import com.jatin.user_profile.service.UserProfileService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * UserProfileServlet
 */
public class UserProfileServlet extends HttpServlet {

    private final UserProfileService userProfileService = new UserProfileService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equalsIgnoreCase(action)) {
            String userId = request.getParameter("userId");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            UserProfile userProfile = new UserProfile(firstName, lastName, email);
            boolean created = userProfileService.createUserProfile(userId, userProfile);

            response.getWriter().println(created ? "User profile created" : "User ID already exists");
        } else if ("update".equalsIgnoreCase(action)) {
            String userId = request.getParameter("userId");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            UserProfile updatedProfile = new UserProfile(firstName, lastName, email);
            boolean updated = userProfileService.updateUserProfile(userId, updatedProfile);

            response.getWriter().println(updated ? "User profile updated" : "User ID does not exist");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        UserProfile userProfile = userProfileService.getUserProfile(userId);

        if (userProfile != null) {
            response.getWriter().println(userProfile);
        } else {
            response.getWriter().println("User profile not found");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        boolean deleted = userProfileService.deleteUserProfile(userId);

        response.getWriter().println(deleted ? "User profile deleted" : "User ID does not exist");
    }
}
