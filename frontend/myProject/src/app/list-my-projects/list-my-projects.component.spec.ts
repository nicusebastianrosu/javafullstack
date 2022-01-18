import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMyProjectsComponent } from './list-my-projects.component';

describe('ListMyProjectsComponent', () => {
  let component: ListMyProjectsComponent;
  let fixture: ComponentFixture<ListMyProjectsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListMyProjectsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMyProjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
