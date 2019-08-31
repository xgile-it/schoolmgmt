package org.schools.students.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.schools.students.Daos.StudentDaos;
import org.schools.students.models.Students;






    /**
     * ControllerServlet.java
     * This servlet acts as a page controller for the application, handling all
     * requests from the user.
     * @email Ramesh Fadatare
     */

    @WebServlet("/")
    public class StudentsServletController extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private StudentDaos studentDAO;

        public void init() {

            System.out.println("Inside Init Method....");
            studentDAO = new StudentDaos();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getServletPath();

            try {
                switch (action) {
                    case "/new":
                        showNewForm(request, response);
                        break;
                    case "/insert":
                        insertUser(request, response);
                        break;
                    case "/delete":
                        deleteUser(request, response);
                        break;
                    case "/edit":
                        showEditForm(request, response);
                        break;
                    case "/update":
                        updateUser(request, response);
                        break;
                    default:
                        listUser(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        private void listUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List < Students > listStudents = studentDAO.selectAllUsers();
            request.setAttribute("listUser", listStudents);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
            dispatcher.forward(request, response);
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Students existingUser = studentDAO.selectStudentsByNumber(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            request.setAttribute("students", existingUser);
            dispatcher.forward(request, response);

        }

        private void insertUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            String studentNumber=request.getParameter("studentNumber");
            int studentno=Integer.parseInt(studentNumber);
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String dob = request.getParameter("dob");
            String grade = request.getParameter("grade");
            String address = request.getParameter("address");
            String parentsContacts = request.getParameter("parentContacts");
            Students newUser = new Students(1234,fname, lname, dob,grade,address,parentsContacts);

            studentDAO.insertStudents(newUser);
            response.sendRedirect("list");
        }

        private void updateUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String dob = request.getParameter("dob");
            String grade = request.getParameter("grade");
            String address = request.getParameter("address");
            String parentsContacts = request.getParameter("parentsContacts");
            Students studentDetail = new Students(1234,fname, lname, dob,grade,address,parentsContacts);



            studentDAO.updateStudenst(studentDetail);
            response.sendRedirect("list");
        }

        private void deleteUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            studentDAO.deleteUser(id);
            response.sendRedirect("list");

        }
    }

