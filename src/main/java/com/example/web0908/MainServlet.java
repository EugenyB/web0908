package com.example.web0908;

import com.example.web0908.data.Artist;
import com.example.web0908.data.ArtistBean;
import com.example.web0908.data.ArtistDao;
import com.example.web0908.logic.TabulationBean;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "mainServlet", value = {"/main", "/artists", "/add_artist"})
public class MainServlet extends HttpServlet {

    @Resource(name = "jdbc/chinook")
    DataSource dataSource;

    private ArtistDao artistDao;

    @SneakyThrows
    public void init() {
        artistDao = new ArtistDao(dataSource);
    }

    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArtistBean ab = new ArtistBean(artistDao.findAll());
        request.setAttribute("ab", ab);
        request.getRequestDispatcher("/artists.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().endsWith("/add_artist")) {
            addArtist(request, response);
        } else processRequest(request, response);
    }

    private void addArtist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        artistDao.add(new Artist(0, request.getParameter("artist")));
        response.sendRedirect("artists");
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double start = Double.parseDouble(request.getParameter("start"));
        double finish = Double.parseDouble(request.getParameter("finish"));
        double step = Double.parseDouble(request.getParameter("step"));

        TabulationBean tb = new TabulationBean(start, finish, step);
        request.setAttribute("tb", tb);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    public void destroy() {
    }
}