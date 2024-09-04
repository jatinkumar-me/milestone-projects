<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>User Profile Management</title>
    </head>

    <body>
        <h2>Create User Profile</h2>
        <form action="user-profile" method="post">
            <input type="hidden" name="action" value="create" />
            User ID: <input type="text" name="userId" /><br />
            First Name: <input type="text" name="firstName" /><br />
            Last Name: <input type="text" name="lastName" /><br />
            Email: <input type="text" name="email" /><br />
            <input type="submit" value="Create Profile" />
        </form>

        <h2>Update User Profile</h2>
        <form action="user-profile" method="post">
            <input type="hidden" name="action" value="update" />
            User ID: <input type="text" name="userId" /><br />
            First Name: <input type="text" name="firstName" /><br />
            Last Name: <input type="text" name="lastName" /><br />
            Email: <input type="text" name="email" /><br />
            <input type="submit" value="Update Profile" />
        </form>

        <h2>Get User Profile</h2>
        <form action="user-profile" method="get">
            User ID: <input type="text" name="userId" /><br />
            <input type="submit" value="Get Profile" />
        </form>

        <h2>Delete User Profile</h2>
        <form action="user-profile" method="post">
            <input type="hidden" name="_method" value="delete" />
            User ID: <input type="text" name="userId" /><br />
            <input type="submit" value="Delete Profile" />
        </form>
    </body>

    </html>
