import subprocess

MAIN_DIR = "semantic_book"


def start() -> None:
    """Start the program. Ensures that the program is properly typed"""
    check_typings()
    _system_or_die(["poetry", "run", "python", MAIN_DIR])


def check_typings() -> None:
    """Check that the program is properly typed"""
    _system_or_die(["poetry", "run", "mypy", MAIN_DIR])


def dev() -> None:
    """Use this to check typings quicker while developing, uses incremental caching"""
    _system_or_die(["poetry", "run", "dmypy", "run", "--", MAIN_DIR])


def test() -> None:
    """Run the tests"""
    dev()
    _system_or_die(["poetry", "run", "pytest"])


def test_watch() -> None:
    """Run the tests, in watch mode""" ""
    dev()
    _system_or_die(["poetry", "run", "ptw"])


def _system_or_die(command: list[str]) -> None:
    try:
        subprocess.check_call(command)
    except subprocess.CalledProcessError:
        exit(1)
