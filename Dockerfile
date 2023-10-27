FROM selenium/standalone-edge
USER root
COPY certs/ /etc/certs

RUN apt-get update -qqy \
  && apt-get -qqy install \
  libnss3-tools \
  && rm -rf /var/lib/apt/lists/* /var/cache/apt/*

RUN mkdir -p -m755 /home/seluser/.pki/nssdb
RUN certutil -d sql:/home/seluser/.pki/nssdb -N --empty-password
RUN certutil -d sql:/home/seluser/.pki/nssdb -A -t ",," -n dhs_development_intermediate -i /etc/certs/DHS_Development_Intermediate.crt
#&& pk12util -d sql:/home/seluser/.pki/nssdb -i client_cert.p12 -W password_of_clent_cer \
RUN certutil -d sql:/home/seluser/.pki/nssdb -A -t "C,," -n treasury_dev_root.cer -i /etc/certs/treasury_dev_root.cer
