package com.example.admin.picasosample;

public class Song {
    public String song;
    public String singer;
    public String url_song;
    public String genres;

    public Song(String song, String singer, String url_song, String genres) {
        this.song = song;
        this.singer = singer;
        this.url_song = url_song;
        this.genres = genres;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUrl_song() {
        return url_song;
    }

    public void setUrl_song(String url_song) {
        this.url_song = url_song;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
