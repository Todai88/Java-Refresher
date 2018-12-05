# Java version

Using openjdk-11.

To change jdk version:

* Download tar from [Oracle](https://jdk.java.net/).
* UnTar the tarball `tar xzvf openjdk-{}_linux-x64_bin.tar.gz` where `{}` is the version.
* Move the extracted files `sudo mv jdk-{} /usr/lib/jvm/java-{}-openjdk-amd64/`, again, where `{}` is the jdk-version.
* Add the new java alternatives to your `update-alternatives`:
    - `sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-{}-openjdk-amd64/bin/java 1`
    - `sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/java-{}-openjdk-amd64/bin/javac 1`
* Update your system's default Java version `sudo update-alternatives --config java` and `sudo update-alternatives --config javac`, choosing the version you downloaded.

