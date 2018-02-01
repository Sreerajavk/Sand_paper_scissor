# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render , redirect
from django.http import HttpResponse
from django.contrib.auth import authenticate,login,logout
from django.contrib.auth.models import User

# Create your views here.

from models import details

def index(request):

    val = details.objects.all()
    data = {'data': val}
    return render(request, 'polls/home.html', data)

def detail(request , id):

    val = details.objects.get(pk = id)
    data = {'data': val}
    return render(request , 'polls/detail.html' , data )

def home(request):
    return HttpResponse('You have sucessfully logged in ')

def signup(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        password2 = request.POST.get('confirm_password')
        if password != password2:
            data = {'message': 'password does not match'}
            return render (request, 'polls/signup.html' , data)
        else:
            user = User.objects.create_user(username= username , password = password)
            return redirect('/polls/login/')
    else:
        return render(request , 'polls/signup.html')

def pro(request):

    user = request.user
    form = {'form': user}
    return render(request, 'polls/profile.html' , form)

def Login(request):
    if request.method == 'POST':

        username = request.POST['username']
        password = request.POST['password']
        user = authenticate(request , username = username , password = password)
        if user is not None:
            login(request , user)
            return redirect ('/home/')
        else:
            return HttpResponse('You cannot login here')
    else:
        return render (request, 'polls/login_page.html')





    
