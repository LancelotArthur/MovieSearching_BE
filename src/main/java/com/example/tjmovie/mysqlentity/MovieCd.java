package com.example.tjmovie.mysqlentity;


import javax.persistence.*;


@Entity
@Table(name = "movie_cd")
public class MovieCd {

    @Id
    private int id;

    private String asin;

    private String name;

    private String format;

    private String subtitles;

    private String region;

    private String language;

    private int numberOfDiscs;

    private String rated;

    private String studio;

    private String runTime;

    private String aspectRadio;

    private String dubbed;

    private String dvdReleaseData;

    private String vhsReleaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public void setNumberOfDiscs(int numberOfDiscs) {
        this.numberOfDiscs = numberOfDiscs;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getAspectRadio() {
        return aspectRadio;
    }

    public void setAspectRadio(String aspectRadio) {
        this.aspectRadio = aspectRadio;
    }

    public String getDubbed() {
        return dubbed;
    }

    public void setDubbed(String dubbed) {
        this.dubbed = dubbed;
    }

    public String getDvdReleaseData() {
        return dvdReleaseData;
    }

    public void setDvdReleaseData(String dvdReleaseData) {
        this.dvdReleaseData = dvdReleaseData;
    }

    public String getVhsReleaseDate() {
        return vhsReleaseDate;
    }

    public void setVhsReleaseDate(String vhsReleaseDate) {
        this.vhsReleaseDate = vhsReleaseDate;
    }
}
