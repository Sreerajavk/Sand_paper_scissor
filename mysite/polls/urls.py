
from django.conf.urls import url

from . import views
from django.contrib.auth.views import login


urlpatterns = [
    url(r'^$' , views.index , name = 'index'), 
    url(r'^(?P<id>[0-9]+)' , views.detail , name = 'detail'),
    url(r'^login/' ,login , {'template_name': 'polls/login_page.html'}),
    url(r'^signup/' , views.signup , name = 'signup'),
    url(r'^profile/' , views.pro, name = 'profile'),
    url(r'^loginpage/' , views.Login , name = 'login')
    
]