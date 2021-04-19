#!/usr/bin/env bash

set -ex

# for openssl 1.1+ we need to add -pbkdf2 to remove the
# warning but that option does not exist in openssl 1.0.x

export GPG_TTY=$(tty)

openssl enc -aes-256-cbc -pass pass:${GPG_ENCPHRASE} -out yavin-dev_pubring.gpg.enc -in yavin-dev_pubring.gpg -pbkdf2
openssl enc -aes-256-cbc -pass pass:${GPG_ENCPHRASE} -out yavin-dev_secring.gpg.enc -in yavin-dev_secring.gpg -pbkdf2