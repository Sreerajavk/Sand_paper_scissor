# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.contrib import admin

from polls.models import details ,userprofile

# Register your models here.
admin.site.register(userprofile)
admin.site.register(details)
