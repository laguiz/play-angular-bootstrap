//import com.jmparsons.plugin.LesscPlugin._

name := "play-angular-bootstrap"

version := "1.0-SNAPSHOT"

play.Project.playJavaSettings

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  //Apache commons
  "commons-collections" % "commons-collections" % "3.2.1",
  "org.apache.commons" % "commons-lang3" % "3.1"
)     

def customLessEntryPoints(base: File): PathFinder = (
    //Compile Boostrap CSS
    //(base / "app" / "assets" / "stylesheets" / "bootstrap" / "bootstrap.less") +++
    //Compile Boostrap CSS Theme
    //(base / "app" / "assets" / "stylesheets" / "bootstrap" / "theme" / "bootstrap-theme.less") +++
    //Compile Application Specific CSS
    (base / "app" / "assets" / "stylesheets" / "app" / "app-main.less") //    
)
    
lessEntryPoints <<= baseDirectory(customLessEntryPoints)

requireJs += "app-main.js"
