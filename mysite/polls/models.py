# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models
from django.contrib.auth.models import User

# Create your models here.
class details(models.Model):
    Name = models.CharField(max_length = 100)
    Age =  models.IntegerField()
    dob = models.DateTimeField()

    def __str__(self):
        return self.Name

class userprofile(models.Model):
    User = models.OneToOneField(User)
    Name = models.OneToOneField(details)
    city = models.CharField(max_length = 100)

        
