// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Lessc Play Plugin repository https://github.com/jmparsons/play-lessc
//resolvers += "JMParsons Releases" at "http://jmparsons.github.io/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.0")

// Lessc Play Plugin
//addSbtPlugin("com.jmparsons" % "play-lessc" % "0.1.0")
