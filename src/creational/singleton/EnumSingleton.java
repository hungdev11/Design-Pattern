package creational.singleton;

// instance init when enum is loaded by JVM, can load before use by call in static block
// enum solve Serialization/Deserialization problem instead of use readResolve (situation that in distributed system we want to save in file and load later)
public enum EnumSingleton {
    INSTANCE
}
