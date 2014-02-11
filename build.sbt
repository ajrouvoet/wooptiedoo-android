import android.Keys._

android.Plugin.androidBuild

name := "Wooptiedoo"

scalaVersion := "2.10.3"

platformTarget in Android := "android-19"

run <<= run in Android

install <<= install in Android
