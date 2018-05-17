name := "fhirproto"

version := "latest"

scalaVersion := "2.11.12"

PB.targets in Compile := Seq(scalapb.gen() -> (sourceManaged in Compile).value)
PB.protoSources in Compile := Seq(baseDirectory.value / "protobuf" / "proto")
PB.includePaths in Compile -= baseDirectory.value / "protobuf" / "proto"
PB.includePaths in Compile += baseDirectory.value / "protobuf"

publishArtifact in (Compile, packageDoc) := false

publishArtifact in packageDoc := false

sources in (Compile, doc) := Seq.empty

lazy val root = project.in(file("."))
