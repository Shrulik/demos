name := "play-jpa-seed"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.2.5.Final"
  )

play.Project.playJavaSettings
