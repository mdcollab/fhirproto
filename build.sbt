import Path.{flat, relativeTo}


name := "fhirproto"

version := "0.0.2-SNAPSHOT"

scalaVersion := "2.11.12"

PB.targets in Compile := Seq(scalapb.gen() -> (sourceManaged in Compile).value)
PB.protoSources in Compile := Seq(baseDirectory.value / "protobuf" / "proto")
PB.includePaths in Compile -= baseDirectory.value / "protobuf" / "proto"
PB.includePaths in Compile += baseDirectory.value / "protobuf"

// publish generated sources
mappings in (Compile, packageSrc) ++= {
  val srcs = (managedSources in Compile).value
  val sdirs = (managedSourceDirectories in Compile).value
  val base = baseDirectory.value
  (srcs --- sdirs --- base) pair (relativeTo(sdirs) | relativeTo(base) | flat)
}

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
)

licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html"))

homepage := Some(url("https://github.com/mdcollab/fhirproto"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/mdcollab/fhirproto"),
    "scm:git@github.com:mdcollab/fhirproto.git"
  )
)

developers := List(
  Developer(
    id    = "berrytj",
    name  = "Tom Berry",
    email = "tom@carbonhealth.com",
    url   = url("http://carbonhealth.com")
  )
)

organization := "com.carbonhealth"

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

lazy val root = project.in(file("."))
