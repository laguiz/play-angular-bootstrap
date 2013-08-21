import sbt._
import Keys._
import play.Project._
import com.jmparsons.plugin.LesscPlugin._

object ApplicationBuild extends Build {

  val appName = "play-angular-bootstrap"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,

    //Apache commons
    "commons-collections" % "commons-collections" % "3.2.1",
    "org.apache.commons" % "commons-lang3" % "3.1")

  // Only compile the specific less files like bootstrap.less, ADS less and fontawesomein the stylesheets directory
  def customLessEntryPoints(base: File): PathFinder = (

    //Compile Boostrap CSS
    (base / "app" / "assets" / "stylesheets" / "bootstrap" / "bootstrap.less") +++
    //Compile Boostrap CSS Theme
    (base / "app" / "assets" / "stylesheets" / "bootstrap" / "theme" / "bootstrap-theme.less") +++
    //Compile Application Specific CSS
    (base / "app" / "assets" / "stylesheets" / "app" / "app-main.less") //
    
    )

  val main = play.Project(appName, appVersion, appDependencies)
    .settings(lesscSettings: _*)
    .settings( // Add your own project settings here      

      //Default Less Entry Points is removed but instead we use the play-lessc plugin
      lessEntryPoints := Nil,
      lesscEntryPoints in Compile <<= baseDirectory(customLessEntryPoints))

}
