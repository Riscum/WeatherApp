package apps.df.weatherapp.domain.commands

public interface Command<T> {
    fun execute(): T
}
